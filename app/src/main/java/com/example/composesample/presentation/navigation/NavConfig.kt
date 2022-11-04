package com.example.composesample.presentation.navigation

import com.example.composesample.presentation.listDrinks.ListDrinksScreen
import com.roudikk.navigator.core.NavigationConfig

object NavConfig {

    val Default: NavigationConfig
        get() = NavigationConfig.SingleStack(
            defaultTransition = MaterialSharedAxisTransitionXY,
            initialNavigationNode = ListDrinksScreen()
        )
}