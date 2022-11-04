package com.example.composesample.data.api.model

import com.squareup.moshi.Json

data class DrinkInfoList(
    @Json(name = "drinks") val drinkInfo: List<DrinkInfo>
)
