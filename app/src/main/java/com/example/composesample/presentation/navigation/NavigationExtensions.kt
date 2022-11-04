package com.example.composesample.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModelStoreOwner
import com.roudikk.navigator.Navigator

val LocalDefaultNavigator = staticCompositionLocalOf<Navigator> { error("Must be provided.") }

@Composable
fun findDefaultNavigator(): Navigator {
    return LocalDefaultNavigator.current
}

val LocalNavHostViewModelStoreOwner = compositionLocalOf<ViewModelStoreOwner> {
    error("Must be provided")
}