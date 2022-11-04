package com.example.composesample.di

import com.example.composesample.data.api.DrinkApi
import com.example.composesample.data.repository.DrinkRepositoryImpl
import com.example.composesample.domain.repositoryApi.DrinkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DrinkRepositoryModule {

    @Singleton
    @Provides
    fun providesDrinkApi(
        retrofit: Retrofit
    ) : DrinkApi = retrofit.create(DrinkApi::class.java)

    @Singleton
    @Provides
    fun providesDrinkRepository(
        drinkApi: DrinkApi
    ) : DrinkRepository = DrinkRepositoryImpl(drinkApi)
}