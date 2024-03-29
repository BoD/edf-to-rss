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

const val SAMPLE_DATA = """{
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
