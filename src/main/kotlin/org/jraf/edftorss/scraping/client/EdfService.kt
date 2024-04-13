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

package org.jraf.edftorss.scraping.client

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.jraf.edftorss.scraping.json.JsonElectricityConsumptionsResponse
import org.jraf.edftorss.scraping.json.JsonGasConsumptionsResponse
import org.jraf.edftorss.scraping.json.JsonSitesResponse

class EdfService(
  private val httpClient: HttpClient,
) {
  companion object {
    private const val URL_BASE = "https://suiviconso.edf.fr/api"
  }


  suspend fun getSites(): List<JsonSitesResponse> {
    return httpClient.get("$URL_BASE/v1/client/sites") {
      contentType(ContentType.Application.Json)
    }.body()
  }

  suspend fun getElectricityConsumptions(
    personExtId: String,
    siteExtId: String,
    // Format: 2024-04-05T22:00:00Z
    beginTs: String,
    endTs: String,
  ): JsonElectricityConsumptionsResponse {
    return httpClient.get("$URL_BASE/v2/sites/-/consumptions/load-curve") {
      header("person-ext-id", personExtId)
      header("site-ext-id", siteExtId)
      parameter("beginTs", beginTs)
      parameter("endTs", endTs)
      parameter("stepUnit", "MINUTES")
      parameter("stepValue", "30")
      contentType(ContentType.Application.Json)
    }.body()
  }

  suspend fun getGasConsumption(
    personExtId: String,
    siteExtId: String,
    // Format: 2024-04-05
    beginDate: String,
    endDate: String,
  ): List<JsonGasConsumptionsResponse> {
    return httpClient.get("$URL_BASE/v1/sites/-/smart-daily-gas-consumptions") {
      header("person-ext-id", personExtId)
      header("site-ext-id", siteExtId)
      parameter("begin-date", beginDate)
      parameter("end-date", endDate)
      contentType(ContentType.Application.Json)
    }.body()
  }
}
