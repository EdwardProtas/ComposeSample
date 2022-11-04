package com.example.composesample.domain.useCase

import com.example.composesample.domain.model.DrinkInfo
import com.example.composesample.domain.repositoryApi.DrinkRepository
import javax.inject.Inject

class GetDrinkDataUseCase @Inject constructor(
    private val drinkRepository: DrinkRepository
) : UseCase<String, DrinkInfo>() {

    override suspend fun invoke(parameters: String): DrinkInfo {
        return drinkRepository.getDrinkDataById(parameters)
    }
}