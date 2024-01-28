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

{
  "period": {
    "startTime": "2024-01-17T00:00:00+01:00",
    "endTime": "2024-01-17T23:59:59+01:00"
  },
  "step": "PT30M",
  "units": {
    "cost": "EUR",
    "energyMeter": "KWH"
  },
  "consumptions": [
    {
      "period": {
        "startTime": "2024-01-17T00:00:00+01:00",
        "endTime": "2024-01-17T00:30:00+01:00"
      },
      "energyMeter": {
        "total": 1.051,
        "byTariffHeading": {
          "HC": 1.051
        }
      },
      "cost": {
        "total": 0.2032428716845878,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.19212279999999998
        }
      },
      "quality": 1,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-17T00:30:00+01:00",
        "endTime": "2024-01-17T01:00:00+01:00"
      },
      "energyMeter": {
        "total": 1.024,
        "byTariffHeading": {
          "HC": 1.024
        }
      },
      "cost": {
        "total": 0.1983072716845878,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.1871872
        }
      },
      "quality": 1,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    }
  ]
}

 */

@Serializable
data class JsonConsumptionsResult(
  val consumptions: List<JsonConsumption>,
)

