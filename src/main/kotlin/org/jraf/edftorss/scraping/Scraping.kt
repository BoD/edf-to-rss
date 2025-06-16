/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2024-present Benoit 'BoD' Lubek (BoD@JRAF.org)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jraf.edftorss.scraping

import com.microsoft.playwright.APIResponse
import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import com.microsoft.playwright.options.LoadState
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.jraf.edftorss.scraping.client.EdfClient
import org.jraf.edftorss.scraping.json.JsonAccessTokenResponse
import org.jraf.edftorss.scraping.json.JsonElectricityConsumptionsResponse
import org.jraf.edftorss.scraping.json.JsonGasConsumptionsResponse
import org.jraf.edftorss.util.attempt
import org.jraf.edftorss.util.logd
import org.jraf.edftorss.util.logw
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.concurrent.thread

private const val ATTEMPTS = 20

private val DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd")


class Scraping(
  private val storageStateFolder: String,
  private val email: String,
  private val password: String,
  private val addressRegex: String,
) {
  var electricityConsumptions: JsonElectricityConsumptionsResponse? = null
  var gasConsumptions: List<JsonGasConsumptionsResponse>? = null
  var lastSuccessScrapingDate: ZonedDateTime = ZonedDateTime.now()

  private val json: Json by lazy {
    Json {
      ignoreUnknownKeys = true
      useAlternativeNames = false
    }
  }

  private fun scrapeAccessToken(headless: Boolean): String {
    var jsonAccessTokenResponse: JsonAccessTokenResponse? = null
    Playwright.create().use { playwright ->
      playwright.firefox().launch(BrowserType.LaunchOptions().setHeadless(headless))
        .use { browser ->
          val browserContext = browser.newContext(
            Browser.NewContextOptions()
              .setStorageStatePath(Paths.get(storageStateFolder, "storage-state.json"))
          ).apply {
            setDefaultTimeout(45_000.0)
          }
          val page = browserContext.newPage()

          page.route({ url -> url.contains("INTERNET/access_token") }) { route ->
            logd("Got request to access_token")
            val response: APIResponse = route.fetch()
            val body = response.text()
            logd("Got access token: $body")
            jsonAccessTokenResponse = json.decodeFromString(body)
            browserContext.close()
            browser.close()
//            route.fulfill(Route.FulfillOptions().setBody(body))
          }
          logd("Navigating to EDF website")
          page.navigate("https://suiviconso.edf.fr/comprendre")

          // 2025-03-11 - Apparently there is no Cookie banner anymore...
//          logd("Cookies...")
//          page.getByLabel("Refuser les cookies EDF").click()

          logd("Entering email")
          page.getByLabel("E-mail").click()
          page.getByLabel("E-mail").fill(email)
          page.getByLabel("Suivant - étape suivante de").click()

          logd("Entering password")
          page.getByLabel("Mot de passe", Page.GetByLabelOptions().setExact(true)).click()
          page.getByLabel("Mot de passe", Page.GetByLabelOptions().setExact(true)).fill(password)
          page.getByLabel("Suivant - Me connecter à mon").click()


          logd("Waiting for the page to finish loading")
          try {
            page.waitForTimeout(10000.0)
            page.waitForLoadState(LoadState.NETWORKIDLE)
          } catch (t: Throwable) {
            // Happens when closing the browser - if we have the access token, this is expected
            if (jsonAccessTokenResponse == null) {
              throw t
            }
          }
        }
    }

    if (jsonAccessTokenResponse == null) {
      throw Exception("Scraping access token didn't work")
    }
    logd("Scraping access token worked")
    return jsonAccessTokenResponse!!.access_token
  }

  private fun scrape(headless: Boolean) {
    logd("Scraping access token")
    val accessToken = scrapeAccessToken(headless)
    logd("Scraped access token: $accessToken")
    val edfClient = EdfClient(accessToken)
    runBlocking {
      logd("Getting sites")
      val sites = edfClient.getSites().getOrThrow()
      val site = sites.first { Regex(addressRegex).matches(it.address) }
      logd("Found site: $site")

      val personExtId = site.personExternalId
      val siteExtId = site.siteExternalId

      logd("Calling lastLoadCurve - whatever that does")
      edfClient.lastLoadCurve(
        personExtId,
        siteExtId,
        ZonedDateTime.now().withZoneSameInstant(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS).toString()
      ).getOrThrow()

      logd("Getting electricity consumption")
      val nowTruncated = ZonedDateTime.now().toInstant()
        .atZone(ZoneOffset.systemDefault())
        .truncatedTo(ChronoUnit.DAYS)
      // Yesterday at midnight, in UTC
      val oneDayAgoAtMidnight: ZonedDateTime = nowTruncated
        .minusDays(1)
        .withZoneSameInstant(ZoneOffset.UTC)

      // Today at midnight minus one second, in UTC
      val todayAtMidnight = nowTruncated
        .minusSeconds(1)
        .withZoneSameInstant(ZoneOffset.UTC)

      attempt(10) {
        val electricityConsumptions = edfClient.getElectricityConsumption(
          personExtId,
          siteExtId,
          DateTimeFormatter.ISO_ZONED_DATE_TIME.format(oneDayAgoAtMidnight),
          DateTimeFormatter.ISO_ZONED_DATE_TIME.format(todayAtMidnight),
        ).getOrThrow()
        logd("Got electricity consumption")
        if (electricityConsumptions.consumptions.sumOf { it.energyMeter.total } == 0.0) {
          throw Exception("Electricity consumption is 0 - server returned bogus data")
        }

        this@Scraping.electricityConsumptions = electricityConsumptions
      }

      logd("Getting gas consumption")
      val nowLocal = LocalDateTime.now()
      // One month ago, minus 3 days
      val oneMonthAgo = nowLocal.minusMonths(1).minusDays(3)
      val gasConsumptions = edfClient.getGasConsumption(
        personExtId,
        siteExtId,
        oneMonthAgo.format(DATE_FORMATTER),
        nowLocal.format(DATE_FORMATTER),
      ).getOrThrow()
      logd("Got gas consumption")
      this@Scraping.gasConsumptions = gasConsumptions
    }
  }

  private fun fakeScrape() {
    this.electricityConsumptions = json.decodeFromString(SAMPLE_DATA_ELECTRICITY)
    this.gasConsumptions = json.decodeFromString(SAMPLE_DATA_GAS)
  }

  fun start() {
    thread {
      while (true) {
        try {
          attempt(ATTEMPTS) {
            logd("Starting scraping")
//            fakeScrape()
//            scrape(headless = false)
            scrape(headless = true)
            logd("Scraping success")
            lastSuccessScrapingDate = ZonedDateTime.now()
          }
        } catch (e: Exception) {
          logw(e, "Scraping failed after $ATTEMPTS attempts - giving up for today")
        }

        // Wait until tomorrow, at 10:30am
        val now = LocalDateTime.now()
        val tomorrow = now.plusDays(1).withHour(10).withMinute(30).withSecond(0)
        val secondsToWait = now.until(tomorrow, ChronoUnit.SECONDS)
        logd("Waiting $secondsToWait seconds until tomorrow at 10:30am")
        Thread.sleep(secondsToWait * 1000)
      }
    }
  }
}
