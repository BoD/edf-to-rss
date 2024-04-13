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

package org.jraf.edftorss.scraping.json

import kotlinx.serialization.Serializable

/*

[
    {
        "day": "2024-03-07",
        "standingCharge": 0.6514354838709678,
        "totalCost": 1.508968531230968,
        "consumption": {
            "energy": 9.7668912,
            "cost": 0.85753304736,
            "energyM3": 0.88,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-08",
        "standingCharge": 0.6514354838709678,
        "totalCost": 1.966969136070968,
        "consumption": {
            "energy": 14.983299,
            "cost": 1.3155336522,
            "energyM3": 1.35,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-09",
        "standingCharge": 0.6514354838709678,
        "totalCost": 0.7878611959509678,
        "consumption": {
            "energy": 1.5538236,
            "cost": 0.13642571208,
            "energyM3": 0.14,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-04-06",
        "standingCharge": 0.67315,
        "totalCost": 0.67315,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    }
]

 */

@Serializable
data class JsonGasConsumptionsResponse(
  val day: String,
  val standingCharge: Double,
  val totalCost: Double,
  val consumption: JsonGasConsumption,
)

@Serializable
data class JsonGasConsumption(
  val energy: Double,
  val cost: Double,
  val energyM3: Double,
  val conversionFactor: Double,
)
