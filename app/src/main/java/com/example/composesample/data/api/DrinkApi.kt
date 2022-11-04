package com.example.composesample.data.api

import com.example.composesample.data.api.model.DrinkInfoList
import com.example.composesample.data.api.model.Drinks
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkApi {

    @GET("api/json/v1/1/search.php?f=a")
    suspend fun getListDrinks() : Drinks

    @GET("api/json/v1/1/lookup.php")
    suspend fun getDrinkDataById(
        @Query("i") id: String
    ) : DrinkInfoList
}