package com.example.composesample.presentation.listDrinks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composesample.domain.useCase.GetListDrinksUseCase
import com.example.composesample.domain.model.DrinkData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListDrinksViewModel @Inject constructor(
    private val getListDrinksUseCase: GetListDrinksUseCase
) : ViewModel() {

    private val _listDrinks = MutableStateFlow<List<DrinkData>>(emptyList())
    val listDrinks = _listDrinks.asStateFlow()

    init {
        viewModelScope.launch {
            runCatching { getListDrinksUseCase.invoke(Unit) }
                .onSuccess {
                    _listDrinks.value = it
                }
        }
    }
}