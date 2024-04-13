/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2023-present Benoit 'BoD' Lubek (BoD@JRAF.org)
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
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.jraf.edftorss.scraping.json.JsonElectricityConsumptionsResponse
import org.jraf.edftorss.scraping.json.JsonGasConsumptionsResponse
import org.jraf.edftorss.scraping.json.JsonSitesResponse

class EdfClient(val accessToken: String) {
  private val service: EdfService by lazy {
    EdfService(
      provideHttpClient()
    )
  }

  private fun provideHttpClient(): HttpClient {
    return HttpClient {
      install(ContentNegotiation) {
        json(
          Json {
            ignoreUnknownKeys = true
            useAlternativeNames = false
            encodeDefaults = true
          }
        )
      }
      install(Auth) {
        bearer {
          loadTokens {
            BearerTokens(accessToken, "")
          }
        }
      }
      install(HttpTimeout) {
        requestTimeoutMillis = 60_000
        connectTimeoutMillis = 60_000
        socketTimeoutMillis = 60_000
      }
      install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
      }
    }
  }

  suspend fun getSites(): Result<List<JsonSitesResponse>> {
    return runCatching {
      service.getSites()
    }
  }

  suspend fun getElectricityConsumption(
    personExtId: String,
    siteExtId: String,
    beginTs: String,
    endTs: String,
  ): Result<JsonElectricityConsumptionsResponse> {
    return runCatching {
      service.getElectricityConsumptions(personExtId, siteExtId, beginTs, endTs)
    }
  }

  suspend fun getGasConsumption(
    personExtId: String,
    siteExtId: String,
    beginDate: String,
    endDate: String,
  ): Result<List<JsonGasConsumptionsResponse>> {
    return runCatching {
      service.getGasConsumption(personExtId, siteExtId, beginDate, endDate)
    }
  }
}
