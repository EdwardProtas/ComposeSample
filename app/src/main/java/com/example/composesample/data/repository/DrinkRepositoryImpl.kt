package com.example.composesample.data.repository

import com.example.composesample.data.api.DrinkApi
import com.example.composesample.domain.model.DrinkData
import com.example.composesample.data.mapper.toDrinkData
import com.example.composesample.data.mapper.toDrinkInfo
import com.example.composesample.domain.model.DrinkInfo
import com.example.composesample.domain.repositoryApi.DrinkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DrinkRepositoryImpl @Inject constructor(
    private val drinkApi: DrinkApi
) : DrinkRepository {

    override suspend fun getListDrinks(): List<DrinkData> = withContext(Dispatchers.IO) {
        drinkApi.getListDrinks().drinks.map { it.toDrinkData() }
    }

    override suspend fun getDrinkDataById(id: String): DrinkInfo = withContext(Dispatchers.IO) {
        drinkApi.getDrinkDataById(id).drinkInfo.map { it.toDrinkInfo() }[0]
    }
}