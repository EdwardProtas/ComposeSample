package com.example.composesample.presentation.drinkData

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composesample.presentation.navigation.LocalNavHostViewModelStoreOwner
import com.roudikk.navigator.core.Screen
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.parcelize.Parcelize

@Parcelize
class DrinkInfoScreen(private val args: DrinksInfoArgs) : Screen {

    @Composable
    override fun Content() {
        val viewModel = viewModel<DrinkInfoViewModel>(
            viewModelStoreOwner = LocalNavHostViewModelStoreOwner.current
        )

        viewModel.getDrinkInform(args)

        val model = viewModel.drinkInfo.collectAsState().value

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                imageModel = model.imageDrink,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .padding(8.dp)
            )

            Text(
                text = model.nameDrink,
                modifier = Modifier.padding(top = 6.dp),
                fontSize = 24.sp,
                color = Color.White
            )

            Text(
                text = model.instructionCooking,
                modifier = Modifier.padding(6.dp),
                fontSize = 16.sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center
            )
        }
    }
}