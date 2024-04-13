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

const val SAMPLE_DATA_ELECTRICITY = """{
  "period": {
    "startTime": "2024-01-20T00:00:00+01:00",
    "endTime": "2024-01-20T23:59:59+01:00"
  },
  "step": "PT30M",
  "units": {
    "cost": "EUR",
    "energyMeter": "KWH"
  },
  "consumptions": [
    {
      "period": {
        "startTime": "2024-01-20T00:00:00+01:00",
        "endTime": "2024-01-20T00:30:00+01:00"
      },
      "energyMeter": {
        "total": 1.079,
        "byTariffHeading": {
          "HC": 1.079
        }
      },
      "cost": {
        "total": 0.2083612716845878,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.19724119999999998
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T00:30:00+01:00",
        "endTime": "2024-01-20T01:00:00+01:00"
      },
      "energyMeter": {
        "total": 1.045,
        "byTariffHeading": {
          "HC": 1.045
        }
      },
      "cost": {
        "total": 0.2021460716845878,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.19102599999999997
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T01:00:00+01:00",
        "endTime": "2024-01-20T01:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.058,
        "byTariffHeading": {
          "HC": 0.058
        }
      },
      "cost": {
        "total": 0.02172247168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.0106024
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T01:30:00+01:00",
        "endTime": "2024-01-20T02:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.063,
        "byTariffHeading": {
          "HC": 0.063
        }
      },
      "cost": {
        "total": 0.02263647168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.0115164
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T02:00:00+01:00",
        "endTime": "2024-01-20T02:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.038,
        "byTariffHeading": {
          "HC": 0.038
        }
      },
      "cost": {
        "total": 0.01806647168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.006946399999999999
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T02:30:00+01:00",
        "endTime": "2024-01-20T03:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.03,
        "byTariffHeading": {
          "HC": 0.03
        }
      },
      "cost": {
        "total": 0.01660407168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.005483999999999999
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T03:00:00+01:00",
        "endTime": "2024-01-20T03:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.03,
        "byTariffHeading": {
          "HC": 0.03
        }
      },
      "cost": {
        "total": 0.01660407168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.005483999999999999
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T03:30:00+01:00",
        "endTime": "2024-01-20T04:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.069,
        "byTariffHeading": {
          "HC": 0.069
        }
      },
      "cost": {
        "total": 0.02373327168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.0126132
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T04:00:00+01:00",
        "endTime": "2024-01-20T04:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.042,
        "byTariffHeading": {
          "HC": 0.042
        }
      },
      "cost": {
        "total": 0.01879767168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.0076776
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T04:30:00+01:00",
        "endTime": "2024-01-20T05:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.031,
        "byTariffHeading": {
          "HC": 0.031
        }
      },
      "cost": {
        "total": 0.01678687168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.0056668
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T05:00:00+01:00",
        "endTime": "2024-01-20T05:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.029,
        "byTariffHeading": {
          "HC": 0.029
        }
      },
      "cost": {
        "total": 0.01642127168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.0053012
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T05:30:00+01:00",
        "endTime": "2024-01-20T06:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.038,
        "byTariffHeading": {
          "HC": 0.038
        }
      },
      "cost": {
        "total": 0.01806647168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.006946399999999999
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T06:00:00+01:00",
        "endTime": "2024-01-20T06:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.051,
        "byTariffHeading": {
          "HC": 0.051
        }
      },
      "cost": {
        "total": 0.02044287168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.0093228
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T06:30:00+01:00",
        "endTime": "2024-01-20T07:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.025,
        "byTariffHeading": {
          "HC": 0.025
        }
      },
      "cost": {
        "total": 0.01569007168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.00457
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T07:00:00+01:00",
        "endTime": "2024-01-20T07:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.025,
        "byTariffHeading": {
          "HP": 0.025
        }
      },
      "cost": {
        "total": 0.01727007168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.00615
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T07:30:00+01:00",
        "endTime": "2024-01-20T08:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.024,
        "byTariffHeading": {
          "HP": 0.024
        }
      },
      "cost": {
        "total": 0.01702407168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.005904
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T08:00:00+01:00",
        "endTime": "2024-01-20T08:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.063,
        "byTariffHeading": {
          "HP": 0.063
        }
      },
      "cost": {
        "total": 0.02661807168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.015498
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T08:30:00+01:00",
        "endTime": "2024-01-20T09:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.031,
        "byTariffHeading": {
          "HP": 0.031
        }
      },
      "cost": {
        "total": 0.01874607168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.007626
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T09:00:00+01:00",
        "endTime": "2024-01-20T09:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.026,
        "byTariffHeading": {
          "HP": 0.026
        }
      },
      "cost": {
        "total": 0.01751607168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.006396
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T09:30:00+01:00",
        "endTime": "2024-01-20T10:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.028,
        "byTariffHeading": {
          "HP": 0.028
        }
      },
      "cost": {
        "total": 0.01800807168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.006888
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T10:00:00+01:00",
        "endTime": "2024-01-20T10:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.025,
        "byTariffHeading": {
          "HP": 0.025
        }
      },
      "cost": {
        "total": 0.01727007168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.00615
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T10:30:00+01:00",
        "endTime": "2024-01-20T11:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.045,
        "byTariffHeading": {
          "HP": 0.045
        }
      },
      "cost": {
        "total": 0.02219007168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.01107
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T11:00:00+01:00",
        "endTime": "2024-01-20T11:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.091,
        "byTariffHeading": {
          "HP": 0.091
        }
      },
      "cost": {
        "total": 0.03350607168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.022386
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T11:30:00+01:00",
        "endTime": "2024-01-20T12:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.064,
        "byTariffHeading": {
          "HP": 0.064
        }
      },
      "cost": {
        "total": 0.02686407168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.015744
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T12:00:00+01:00",
        "endTime": "2024-01-20T12:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.092,
        "byTariffHeading": {
          "HP": 0.092
        }
      },
      "cost": {
        "total": 0.03375207168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.022632
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T12:30:00+01:00",
        "endTime": "2024-01-20T13:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.085,
        "byTariffHeading": {
          "HC": 0.085
        }
      },
      "cost": {
        "total": 0.02665807168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.015538
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T13:00:00+01:00",
        "endTime": "2024-01-20T13:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.044,
        "byTariffHeading": {
          "HC": 0.044
        }
      },
      "cost": {
        "total": 0.01916327168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HC": 0.008043199999999999
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T13:30:00+01:00",
        "endTime": "2024-01-20T14:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.038,
        "byTariffHeading": {
          "HP": 0.038
        }
      },
      "cost": {
        "total": 0.02046807168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.009348
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T14:00:00+01:00",
        "endTime": "2024-01-20T14:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.051,
        "byTariffHeading": {
          "HP": 0.051
        }
      },
      "cost": {
        "total": 0.02366607168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.012546
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T14:30:00+01:00",
        "endTime": "2024-01-20T15:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.033,
        "byTariffHeading": {
          "HP": 0.033
        }
      },
      "cost": {
        "total": 0.01923807168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.008118
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T15:00:00+01:00",
        "endTime": "2024-01-20T15:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.075,
        "byTariffHeading": {
          "HP": 0.075
        }
      },
      "cost": {
        "total": 0.02957007168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.018449999999999998
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T15:30:00+01:00",
        "endTime": "2024-01-20T16:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.053,
        "byTariffHeading": {
          "HP": 0.053
        }
      },
      "cost": {
        "total": 0.02415807168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.013038
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T16:00:00+01:00",
        "endTime": "2024-01-20T16:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.037,
        "byTariffHeading": {
          "HP": 0.037
        }
      },
      "cost": {
        "total": 0.02022207168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.009101999999999999
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T16:30:00+01:00",
        "endTime": "2024-01-20T17:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.031,
        "byTariffHeading": {
          "HP": 0.031
        }
      },
      "cost": {
        "total": 0.01874607168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.007626
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T17:00:00+01:00",
        "endTime": "2024-01-20T17:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.122,
        "byTariffHeading": {
          "HP": 0.122
        }
      },
      "cost": {
        "total": 0.04113207168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.030012
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T17:30:00+01:00",
        "endTime": "2024-01-20T18:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.076,
        "byTariffHeading": {
          "HP": 0.076
        }
      },
      "cost": {
        "total": 0.02981607168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.018696
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T18:00:00+01:00",
        "endTime": "2024-01-20T18:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.085,
        "byTariffHeading": {
          "HP": 0.085
        }
      },
      "cost": {
        "total": 0.03203007168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.02091
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T18:30:00+01:00",
        "endTime": "2024-01-20T19:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.078,
        "byTariffHeading": {
          "HP": 0.078
        }
      },
      "cost": {
        "total": 0.03030807168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.019188
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T19:00:00+01:00",
        "endTime": "2024-01-20T19:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.109,
        "byTariffHeading": {
          "HP": 0.109
        }
      },
      "cost": {
        "total": 0.03793407168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.026814
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T19:30:00+01:00",
        "endTime": "2024-01-20T20:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.079,
        "byTariffHeading": {
          "HP": 0.079
        }
      },
      "cost": {
        "total": 0.03055407168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.019434
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T20:00:00+01:00",
        "endTime": "2024-01-20T20:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.079,
        "byTariffHeading": {
          "HP": 0.079
        }
      },
      "cost": {
        "total": 0.03055407168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.019434
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T20:30:00+01:00",
        "endTime": "2024-01-20T21:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.139,
        "byTariffHeading": {
          "HP": 0.139
        }
      },
      "cost": {
        "total": 0.04531407168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.034194
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T21:00:00+01:00",
        "endTime": "2024-01-20T21:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.112,
        "byTariffHeading": {
          "HP": 0.112
        }
      },
      "cost": {
        "total": 0.03867207168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.027552
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T21:30:00+01:00",
        "endTime": "2024-01-20T22:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.438,
        "byTariffHeading": {
          "HP": 0.438
        }
      },
      "cost": {
        "total": 0.1188680716845878,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.107748
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T22:00:00+01:00",
        "endTime": "2024-01-20T22:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.237,
        "byTariffHeading": {
          "HP": 0.237
        }
      },
      "cost": {
        "total": 0.06942207168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.058302
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T22:30:00+01:00",
        "endTime": "2024-01-20T23:00:00+01:00"
      },
      "energyMeter": {
        "total": 0.178,
        "byTariffHeading": {
          "HP": 0.178
        }
      },
      "cost": {
        "total": 0.05490807168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.043788
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T23:00:00+01:00",
        "endTime": "2024-01-20T23:30:00+01:00"
      },
      "energyMeter": {
        "total": 0.18,
        "byTariffHeading": {
          "HP": 0.18
        }
      },
      "cost": {
        "total": 0.05540007168458781,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.04428
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    },
    {
      "period": {
        "startTime": "2024-01-20T23:30:00+01:00",
        "endTime": "2024-01-20T23:59:59+01:00"
      },
      "energyMeter": {
        "total": 0.2038866666666667,
        "byTariffHeading": {
          "HP": 0.2038866666666667
        }
      },
      "cost": {
        "total": 0.06127619168458782,
        "standingCharge": 0.01112007168458781,
        "standingChargeByComponents": {},
        "byTariffHeading": {
          "HP": 0.050156120000000005
        }
      },
      "quality": 1.0,
      "errorFlags": [],
      "indexNatures": [],
      "status": "COMPLETE",
      "nature": "REAL",
      "aggregated": false,
      "usingLoadCurve": true
    }
  ]
}"""

const val SAMPLE_DATA_GAS = """
  [
    {
        "day": "2024-03-14",
        "standingCharge": 0.6514354838709678,
        "totalCost": 1.4797344500709677,
        "consumption": {
            "energy": 9.433929,
            "cost": 0.8282989662,
            "energyM3": 0.85,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-15",
        "standingCharge": 0.6514354838709678,
        "totalCost": 2.005947910950968,
        "consumption": {
            "energy": 15.4272486,
            "cost": 1.3545124270800002,
            "energyM3": 1.39,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-16",
        "standingCharge": 0.6514354838709678,
        "totalCost": 0.8073505833909679,
        "consumption": {
            "energy": 1.7757984,
            "cost": 0.15591509952000002,
            "energyM3": 0.16,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-17",
        "standingCharge": 0.6514354838709678,
        "totalCost": 0.9827550703509678,
        "consumption": {
            "energy": 3.7735716,
            "cost": 0.33131958648,
            "energyM3": 0.34,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-18",
        "standingCharge": 0.6514354838709678,
        "totalCost": 1.4699897563509678,
        "consumption": {
            "energy": 9.3229416,
            "cost": 0.81855427248,
            "energyM3": 0.84,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-19",
        "standingCharge": 0.6514354838709678,
        "totalCost": 1.4602450626309678,
        "consumption": {
            "energy": 9.2119542,
            "cost": 0.8088095787599999,
            "energyM3": 0.83,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-20",
        "standingCharge": 0.6514354838709678,
        "totalCost": 2.152118316750968,
        "consumption": {
            "energy": 17.0920596,
            "cost": 1.50068283288,
            "energyM3": 1.54,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-21",
        "standingCharge": 0.6514354838709678,
        "totalCost": 0.6514354838709678,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-22",
        "standingCharge": 0.6514354838709678,
        "totalCost": 1.0899467012709678,
        "consumption": {
            "energy": 4.994433,
            "cost": 0.4385112174,
            "energyM3": 0.45,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-23",
        "standingCharge": 0.6514354838709678,
        "totalCost": 0.6514354838709678,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-24",
        "standingCharge": 0.6514354838709678,
        "totalCost": 1.211810866470968,
        "consumption": {
            "energy": 6.104307,
            "cost": 0.5603753826000001,
            "energyM3": 0.55,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-25",
        "standingCharge": 0.6514354838709678,
        "totalCost": 0.6514354838709678,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-26",
        "standingCharge": 0.6514354838709678,
        "totalCost": 1.3850178029109679,
        "consumption": {
            "energy": 7.9910928,
            "cost": 0.73358231904,
            "energyM3": 0.72,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-27",
        "standingCharge": 0.6514354838709678,
        "totalCost": 1.2729427263909678,
        "consumption": {
            "energy": 6.7702314,
            "cost": 0.62150724252,
            "energyM3": 0.61,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-28",
        "standingCharge": 0.6514354838709678,
        "totalCost": 0.6514354838709678,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-29",
        "standingCharge": 0.6514354838709678,
        "totalCost": 0.6514354838709678,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-30",
        "standingCharge": 0.6514354838709678,
        "totalCost": 0.6514354838709678,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-03-31",
        "standingCharge": 0.6514354838709678,
        "totalCost": 0.6514354838709678,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-04-01",
        "standingCharge": 0.6514354838709678,
        "totalCost": 1.884261325590968,
        "consumption": {
            "energy": 13.4294754,
            "cost": 1.23282584172,
            "energyM3": 1.21,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-04-02",
        "standingCharge": 0.67315,
        "totalCost": 0.67315,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-04-03",
        "standingCharge": 0.67315,
        "totalCost": 0.67315,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-04-04",
        "standingCharge": 0.67315,
        "totalCost": 0.67315,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-04-05",
        "standingCharge": 0.67315,
        "totalCost": 1.18432466818,
        "consumption": {
            "energy": 5.8823322,
            "cost": 0.51117466818,
            "energyM3": 0.53,
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
    },
    {
        "day": "2024-04-07",
        "standingCharge": 0.67315,
        "totalCost": 1.3868655744400002,
        "consumption": {
            "energy": 8.2130676,
            "cost": 0.7137155744400001,
            "energyM3": 0.74,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-04-08",
        "standingCharge": 0.67315,
        "totalCost": 0.67315,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-04-09",
        "standingCharge": 0.67315,
        "totalCost": 0.67315,
        "consumption": {
            "energy": 0.0,
            "cost": 0.0,
            "energyM3": 0.0,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-04-10",
        "standingCharge": 0.67315,
        "totalCost": 1.84981621732,
        "consumption": {
            "energy": 13.5404628,
            "cost": 1.17666621732,
            "energyM3": 1.22,
            "conversionFactor": 11.09874
        }
    },
    {
        "day": "2024-04-11",
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
"""
