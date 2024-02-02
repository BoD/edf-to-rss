/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2022-present Benoit 'BoD' Lubek (BoD@JRAF.org)
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

package org.jraf.edftorss.server

import com.rometools.rome.feed.synd.SyndContentImpl
import com.rometools.rome.feed.synd.SyndEntryImpl
import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.feed.synd.SyndFeedImpl
import com.rometools.rome.io.SyndFeedOutput
import io.ktor.http.ContentType
import io.ktor.http.URLBuilder
import io.ktor.http.withCharset
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.server.plugins.callloging.CallLogging
import io.ktor.server.plugins.origin
import io.ktor.server.request.host
import io.ktor.server.request.httpMethod
import io.ktor.server.request.port
import io.ktor.server.request.uri
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.server.util.toGMTDate
import io.ktor.util.date.toJvmDate
import io.ktor.utils.io.charsets.Charsets
import org.jraf.edftorss.scraping.Scraping
import org.jraf.edftorss.scraping.json.JsonConsumptionsResult
import org.jraf.edftorss.util.logd
import org.slf4j.event.Level
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

private const val PORT = 8080

private val AXIS_HOUR_FORMAT = DateTimeFormatter.ofPattern("H'h'")
private val TITLE_DATE_FORMAT = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy")

class Server(private val scraping: Scraping) {
  fun start() {
    logd("Starting server on port $PORT")
    embeddedServer(CIO, PORT, module = { edfToRssModule() }).start(wait = true)
  }

  private fun Application.edfToRssModule() {
    install(CallLogging) {
      level = Level.DEBUG
      format { call ->
        val status = call.response.status()
        val httpMethod = call.request.httpMethod.value
        val host = call.request.origin.remoteHost
        val userAgent = call.request.headers["User-Agent"]
        "Status: $status, Method: $httpMethod, Host: $host, User agent: $userAgent"
      }
    }

    routing {
      get("/") {
        val selfLink = URLBuilder("${call.request.origin.scheme}://${call.request.host()}${call.portStr()}${call.request.uri}")
          .buildString()
        val date: ZonedDateTime =
          (scraping.jsonConsumptionsResult?.consumptions?.first()?.period?.startTime?.let { ZonedDateTime.parse(it) }
            ?: ZonedDateTime.now())
            .truncatedTo(ChronoUnit.MINUTES)
        val titleFormattedDate = date.format(TITLE_DATE_FORMAT)
        val title = "Consumption for $titleFormattedDate"
        val graphUrl = scraping.jsonConsumptionsResult?.let { getGraphUrl(it, title) }.orEmpty()
        val description = getDescription(title, graphUrl)
        val rssText = getRss(
          selfLink = selfLink,
          date = date,
          title = title,
          description = description,
          graphUrl = graphUrl,
        )
        call.respondText(
          rssText,
          ContentType.Application.Rss.withCharset(Charsets.UTF_8)
        )
      }
    }
  }

  private fun getDescription(title: String, graphUrl: String): String {
    val jsonConsumptionsResult = scraping.jsonConsumptionsResult ?: return "No consumption data available"
    val energyTotal = jsonConsumptionsResult.consumptions.sumOf { it.energyMeter.total }
    val costTotal = jsonConsumptionsResult.consumptions.sumOf { it.cost.total }
    logd("graphUrl: $graphUrl")
    val sumFormat = "%.${2}f"
    return """
      <ul>
        <li>Energy: <b>${sumFormat.format(energyTotal)} kWh</b></li>
        <li>Cost: <b>${sumFormat.format(costTotal)} €</b></li>
      </ul>
      <img src="${graphUrl.replace("&", "&amp;")}">
      """.trimIndent()
  }

  private fun getGraphUrl(jsonConsumptionsResult: JsonConsumptionsResult, title: String): String {
    return URLBuilder("https://chart.googleapis.com/chart")
      .apply {
        parameters.append("cht", "bvg")
        parameters.append("chtt", "$title (kWh)")
        parameters.append("chs", "1000x200")
        parameters.append("chxt", "x,y")
        parameters.append("chxs", "0,000000,14")
        parameters.append("chbh", "a")
        parameters.append("chds", "a")
        parameters.append("chxl", "0:|" + jsonConsumptionsResult.consumptions.mapIndexed { i, consumption ->
          val startTime = ZonedDateTime.parse(consumption.period.startTime)
          if (i % 2 == 1) {
            " "
          } else {
            startTime.format(AXIS_HOUR_FORMAT)
          }
        }.joinToString("|"))
        parameters.append("chd", "t:" + jsonConsumptionsResult.consumptions.map { it.energyMeter.total }.joinToString(","))
      }
      .buildString()
  }

  private fun getRss(
    selfLink: String,
    date: ZonedDateTime,
    title: String,
    description: String,
    graphUrl: String,
  ): String {
    val feed: SyndFeed = SyndFeedImpl()
    feed.feedType = "atom_1.0"
    feed.title = "EDF Consumption"
    feed.description = "EDF Consumption"
    feed.link = selfLink
    feed.uri = selfLink
    feed.publishedDate = date.toInstant().toGMTDate().toJvmDate()

    val entry = SyndEntryImpl()
    entry.title = title
    entry.link = graphUrl
    entry.uri = graphUrl
    entry.contents = listOf(SyndContentImpl().apply {
      type = "text/html"
      value = description
    })
    entry.publishedDate = date.toInstant().toGMTDate().toJvmDate()
    entry.author = "BoD"

    feed.entries = listOf(entry)

    return SyndFeedOutput().outputString(feed)
  }
}

private fun ApplicationCall.portStr() = request.port().let { if (it == 80) "" else ":$it" }
