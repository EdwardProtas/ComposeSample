package com.example.composesample.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.example.composesample.presentation.navigation.LocalNavHostViewModelStoreOwner
import com.example.composesample.presentation.navigation.NavConfig
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.roudikk.navigator.compose.NavContainer
import com.roudikk.navigator.rememberNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()

            systemUiController.setNavigationBarColor(
                color = Color.Transparent,
                darkIcons = !isSystemInDarkTheme(),
                navigationBarContrastEnforced = false
            )

            systemUiController.setStatusBarColor(
                color = Color.Transparent,
                darkIcons = !isSystemInDarkTheme(),
            )

            MaterialTheme {
                val defaultNavigator = rememberNavigator(NavConfig.Default)
                CompositionLocalProvider(
                    LocalNavHostViewModelStoreOwner provides requireNotNull(LocalViewModelStoreOwner.current)
                ) {
                    NavContainer(navigator = defaultNavigator)
                }
            }
            
        }
    }
}