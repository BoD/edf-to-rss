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
import io.ktor.server.application.install
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.server.plugins.calllogging.CallLogging
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
import org.jraf.edftorss.scraping.json.JsonElectricityConsumptionsResponse
import org.jraf.edftorss.scraping.json.JsonGasConsumptionsResponse
import org.jraf.edftorss.util.logd
import org.slf4j.event.Level
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale

private const val PORT = 8080

private val DATE_FORMAT_TITLE = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy")
private val DATE_FORMAT_ELECTRICITY_AXIS = DateTimeFormatter.ofPattern("H'h'")
private val DATE_FORMAT_GAS_AXIS = DateTimeFormatter.ofPattern("d MMM")

private val DECIMAL_FORMAT = DecimalFormat("#.##", DecimalFormatSymbols(Locale.US)).apply {
  minimumFractionDigits = 0
  maximumFractionDigits = 2
}


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
        val headers = call.request.headers
        """
          |
          |-----------------------------------
          |Host: $host
          |Method: $httpMethod
          |Headers:
          ${headers.entries().joinToString("\n") { "|- ${it.key}: ${it.value.joinToString()}" }}
          |Status: $status
          |-----------------------------------
          |
        """.trimMargin()
      }
    }

    routing {
      get("/{consumptionType}") {
        val selfLink = URLBuilder("${call.request.origin.scheme}://${call.request.host()}${call.portStr()}${call.request.uri}")
          .buildString()
        val consumptionType = call.parameters["consumptionType"]
        val scrapingDate: ZonedDateTime = scraping.lastSuccessScrapingDate
        val rssText = when (consumptionType) {
          "electricity" -> {
            val electricityConsumptions = scraping.electricityConsumptions
            val dataDate = electricityConsumptions?.consumptions?.firstOrNull()?.period?.startTime?.let { ZonedDateTime.parse(it) }
              ?.truncatedTo(ChronoUnit.MINUTES)
            var title: String? = null
            var description: String? = null
            var graphUrl: String? = null
            if (dataDate != null && electricityConsumptions != null) {
              val titleFormattedDate = dataDate.format(DATE_FORMAT_TITLE)
              title = "Electricity consumption for $titleFormattedDate"
              graphUrl = getElectricityGraphUrl(electricityConsumptions, title)
              logd("electricity graphUrl: $graphUrl")
              description = getElectricityDescription(electricityConsumptions, graphUrl)
            }
            getRss(
              selfLink = selfLink,
              date = scrapingDate,
              title = title,
              description = description,
              graphUrl = graphUrl,
            )
          }

          "gas" -> {
            val gasConsumptions = scraping.gasConsumptions
            val dataDate = gasConsumptions?.lastOrNull()?.day?.let { LocalDate.parse(it) }
            var title: String? = null
            var description: String? = null
            var graphUrl: String? = null
            if (dataDate != null && gasConsumptions != null) {
              val titleFormattedDate = dataDate.format(DATE_FORMAT_TITLE)
              title = "Gas consumption as of $titleFormattedDate"
              graphUrl = getGasGraphUrl(gasConsumptions, title)
              logd("gas graphUrl: $graphUrl")
              description = getGasDescription(gasConsumptions, graphUrl)
            }
            getRss(
              selfLink = selfLink,
              date = scrapingDate,
              title = title,
              description = description,
              graphUrl = graphUrl,
            )
          }

          else -> throw IllegalArgumentException("Unknown consumption type: $consumptionType")
        }
        call.respondText(
          rssText,
          ContentType.Application.Atom.withCharset(Charsets.UTF_8),
        )
      }
    }
  }

  private fun getElectricityGraphUrl(electricityConsumptions: JsonElectricityConsumptionsResponse, title: String): String {
    return URLBuilder("https://image-charts.com/chart")
      .apply {
        parameters.append("cht", "bvg")
        parameters.append("chtt", "$title (kWh)")
        parameters.append("chs", "999x300")
        parameters.append("chxt", "x,y")
        parameters.append("chxs", "0,000000,14")
        parameters.append("chbh", "a")
        parameters.append("chds", "a")
        parameters.append(
          "chxl",
          "0:|" + electricityConsumptions.consumptions.mapIndexed { i, consumption ->
            val startTime = ZonedDateTime.parse(consumption.period.startTime)
            if (i % 2 == 1) {
              " "
            } else {
              startTime.format(DATE_FORMAT_ELECTRICITY_AXIS)
            }
          }.joinToString("|", postfix = "|"),
        )
        parameters.append(
          "chco",
          electricityConsumptions.consumptions.joinToString(
            "|",
            postfix = "|",
          ) { if (it.isOffPeakHours()) "59a0eb" else "005bbb" },
        )
        parameters.append(
          "chd",
          "t:" + electricityConsumptions.consumptions.joinToString(",") { DECIMAL_FORMAT.format(it.energyMeter.total) },
        )
      }
      .buildString()
  }

  private fun getElectricityDescription(electricityConsumptions: JsonElectricityConsumptionsResponse, graphUrl: String): String {
    val energyTotal = electricityConsumptions.consumptions.sumOf { it.energyMeter.total }
    val costTotal = electricityConsumptions.consumptions.sumOf { it.cost.total }
    val sumFormat = "%.${2}f"
    return """
      <ul>
        <li>Energy: <b>${sumFormat.format(energyTotal)} kWh</b></li>
        <li>Cost: <b>${sumFormat.format(costTotal)} €</b></li>
      </ul>
      <img src="${graphUrl.replace("&", "&amp;")}">
      """.trimIndent()
  }

  private fun getGasGraphUrl(gasConsumption: List<JsonGasConsumptionsResponse>, title: String): String {
    return URLBuilder("https://image-charts.com/chart")
      .apply {
        parameters.append("cht", "bvg")
        parameters.append("chtt", "$title (kWh)")
        parameters.append("chs", "999x300")
        parameters.append("chxt", "x,y")
        parameters.append("chxs", "0,000000,12,min45")
        parameters.append("chbh", "a")
        parameters.append("chds", "a")
        parameters.append(
          "chxl",
          "0:|" + gasConsumption.map { consumption ->
            val dayDate = LocalDate.parse(consumption.day)
            dayDate.format(DATE_FORMAT_GAS_AXIS)
          }.joinToString("|", postfix = "|"),
        )
        parameters.append("chco", "E09000")
        parameters.append("chm", "N*f*,000000,0,-1,13,,e")
        parameters.append(
          "chd",
          "t:" + gasConsumption.joinToString(",") { DECIMAL_FORMAT.format(it.consumption.energy) },
        )
      }
      .buildString()
  }

  private fun getGasDescription(gasConsumption: List<JsonGasConsumptionsResponse>, graphUrl: String): String {
    val firstConsumption = gasConsumption.last()
    val sumFormat = "%.${2}f"
    return """
      <ul>
        <li>Energy: <b>${sumFormat.format(firstConsumption.consumption.energy)} kWh</b></li>
        <li>Cost: <b>${sumFormat.format(firstConsumption.consumption.cost)} €</b></li>
      </ul>
      <img src="${graphUrl.replace("&", "&amp;")}">
      """.trimIndent()
  }

  private fun getRss(
    selfLink: String,
    date: ZonedDateTime,
    title: String?,
    description: String?,
    graphUrl: String?,
  ): String {
    val feed: SyndFeed = SyndFeedImpl()
    feed.feedType = "atom_1.0"
    feed.title = "EDF Consumption"
    feed.description = "EDF Consumption"
    feed.link = selfLink
    feed.uri = selfLink
    feed.publishedDate = date.toInstant().toGMTDate().toJvmDate()

    if (title != null && description != null && graphUrl != null) {
      val entry = SyndEntryImpl()
      entry.title = title
      entry.link = graphUrl
      entry.uri = graphUrl
      entry.contents = listOf(
        SyndContentImpl().apply {
          type = "text/html"
          value = description
        },
      )
      entry.publishedDate = date.toInstant().toGMTDate().toJvmDate()
      entry.author = "BoD"

      feed.entries = listOf(entry)
    }

    return SyndFeedOutput().outputString(feed)
  }
}

private fun ApplicationCall.portStr() = request.port().let { if (it == 80) "" else ":$it" }
