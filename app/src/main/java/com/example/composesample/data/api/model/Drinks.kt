package com.example.composesample.data.api.model

import com.squareup.moshi.Json

data class Drinks(
    @Json(name = "drinks") val drinks: List<DrinkData>
)
