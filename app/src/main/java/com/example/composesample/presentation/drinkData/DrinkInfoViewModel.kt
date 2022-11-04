package com.example.composesample.presentation.drinkData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composesample.domain.model.DrinkInfo
import com.example.composesample.domain.repositoryApi.DrinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinkInfoViewModel @Inject constructor(
    private val drinkRepository: DrinkRepository
) : ViewModel() {

    private val _drinkInfo = MutableStateFlow(DrinkInfo())
    val drinkInfo = _drinkInfo.asStateFlow()

    fun getDrinkInform(params: DrinksInfoArgs) {
        viewModelScope.launch {
            runCatching { drinkRepository.getDrinkDataById(params.id) }
                .onSuccess {
                    _drinkInfo.value = it
                }
        }
    }
}