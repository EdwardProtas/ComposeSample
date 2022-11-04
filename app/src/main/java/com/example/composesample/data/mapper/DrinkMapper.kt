package com.example.composesample.data.mapper

import com.example.composesample.domain.model.DrinkData
import com.example.composesample.domain.model.DrinkInfo
import com.example.composesample.data.api.model.DrinkData as DrinkDataApi
import com.example.composesample.data.api.model.DrinkInfo as DrinkInfoApi

fun DrinkDataApi.toDrinkData(): DrinkData {
    return DrinkData(
        id = id,
        nameDrink = nameDrink,
        imageDrink = imageDrink
    )
}

fun DrinkData.toDrinkDataApi(): DrinkDataApi {
    return DrinkDataApi(
        id = id,
        nameDrink = nameDrink,
        imageDrink = imageDrink
    )
}

fun DrinkInfoApi.toDrinkInfo(): DrinkInfo {
    return DrinkInfo(
        nameDrink = nameDrink,
        imageDrink = imageDrink,
        instructionCooking = instructionCooking
    )
}

fun DrinkInfo.toDrinkInfoApi(): DrinkInfoApi {
    return DrinkInfoApi(
        nameDrink = nameDrink,
        imageDrink = imageDrink,
        instructionCooking = instructionCooking
    )
}