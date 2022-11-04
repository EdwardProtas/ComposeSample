package com.example.composesample.presentation.drinkData

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DrinksInfoArgs(
    val id: String
) : Parcelable
