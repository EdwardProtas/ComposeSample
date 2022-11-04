package com.example.composesample.domain.useCase

import com.example.composesample.domain.model.DrinkData
import com.example.composesample.domain.repositoryApi.DrinkRepository
import javax.inject.Inject

class GetListDrinksUseCase @Inject constructor(
    private val drinkRepository: DrinkRepository
) : UseCase<Unit, List<DrinkData>>() {

    override suspend fun invoke(parameters: Unit): List<DrinkData> {
        return drinkRepository.getListDrinks()
    }
}