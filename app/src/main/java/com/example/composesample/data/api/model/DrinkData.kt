package com.example.composesample.data.api.model

import com.squareup.moshi.Json

@Json(name = "drinks")
data class DrinkData(
    @Json(name = "idDrink") val id: String,
    @Json(name = "strDrink") val nameDrink: String,
    @Json(name = "strDrinkThumb") val imageDrink: String,
)
