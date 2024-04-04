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
import com.microsoft.playwright.Route
import com.microsoft.playwright.options.LoadState
import kotlinx.serialization.json.Json
import org.jraf.edftorss.scraping.json.JsonConsumptionsResult
import org.jraf.edftorss.util.attempt
import org.jraf.edftorss.util.logd
import org.jraf.edftorss.util.logw
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.concurrent.thread

private const val ATTEMPTS = 20

class Scraping(
  private val storageStateFolder: String,
  private val email: String,
  private val password: String,
  private val contractId: String?,
) {
  var jsonConsumptionsResult: JsonConsumptionsResult? = null

  private val json: Json by lazy {
    Json {
      ignoreUnknownKeys = true
      useAlternativeNames = false
    }
  }

  private fun scrape(headless: Boolean) {
    var jsonConsumptionsResult: JsonConsumptionsResult? = null
    Playwright.create().use { playwright ->
      playwright.firefox().launch(BrowserType.LaunchOptions().setHeadless(headless))
        .use { browser ->
          val browserContext = browser.newContext(
            Browser.NewContextOptions().setStorageStatePath(Paths.get(storageStateFolder, "storage-state.json"))
          )
          val page = browserContext.newPage()

          page.route({ url -> url.contains("consumptions/load-curve") }) { route ->
            logd("Got request to json payload")
            val response: APIResponse = route.fetch()
            val body = response.text()
            logd("Got JSON: $body")
            jsonConsumptionsResult = json.decodeFromString(body)
            route.fulfill(Route.FulfillOptions().setBody(body))
          }
          logd("Navigating to EDF website")
          page.navigate("https://equilibre.edf.fr/comprendre")

          logd("Entering email")
          page.getByLabel("E-mail").click()
          page.getByLabel("E-mail").fill(email)
          page.getByLabel("Suivant - étape suivante de").click()

          logd("Entering password")
          page.getByLabel("Mot de passe", Page.GetByLabelOptions().setExact(true)).click()
          page.getByLabel("Mot de passe", Page.GetByLabelOptions().setExact(true)).fill(password)
          page.getByLabel("Suivant - Me connecter à mon").click()

          contractId?.let {
            logd("Entering contract ID")
            page.locator("[id=\"\\$it\"]").click()
          }

          logd("Clicking on 'hour view'")
          page.getByLabel("Accéder à la vue HEURE").click()

          logd("Waiting for the page to finish loading")
          page.waitForLoadState(LoadState.NETWORKIDLE)
        }
    }

    if (jsonConsumptionsResult == null || jsonConsumptionsResult?.consumptions?.sumOf { it.energyMeter.total } == 0.0) {
      throw Exception("Scraping didn't work")
    } else {
      logd("Scraping worked")
      updateJson(jsonConsumptionsResult!!)
    }
  }

  private fun fakeScrape() {
    updateJson(json.decodeFromString(SAMPLE_DATA))
  }

  private fun updateJson(jsonConsumptionsResult: JsonConsumptionsResult) {
    this.jsonConsumptionsResult = jsonConsumptionsResult
  }

  fun start() {
    thread {
      while (true) {
        try {
          attempt(ATTEMPTS) {
            logd("Starting scraping")
//          fakeScrape()
            scrape(headless = true)
            logd("Scraping done")
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
