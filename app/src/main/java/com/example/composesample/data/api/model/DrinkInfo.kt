package com.example.composesample.data.api.model

import com.squareup.moshi.Json

data class DrinkInfo(
    @Json(name = "strDrink") val nameDrink: String,
    @Json(name = "strDrinkThumb") val imageDrink: String,
    @Json(name = "strInstructions") val instructionCooking: String,
)
