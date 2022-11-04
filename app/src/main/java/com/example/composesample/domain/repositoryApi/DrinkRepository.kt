package com.example.composesample.domain.repositoryApi

import com.example.composesample.domain.model.DrinkData
import com.example.composesample.domain.model.DrinkInfo

interface DrinkRepository {

    suspend fun getListDrinks(): List<DrinkData>

    suspend fun getDrinkDataById(id: String): DrinkInfo
}