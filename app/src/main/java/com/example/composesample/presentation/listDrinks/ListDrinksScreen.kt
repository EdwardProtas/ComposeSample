package com.example.composesample.presentation.listDrinks

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composesample.presentation.drinkData.DrinksInfoArgs
import com.example.composesample.presentation.drinkData.DrinkInfoScreen
import com.example.composesample.presentation.navigation.LocalNavHostViewModelStoreOwner
import com.roudikk.navigator.compose.requireNavigator
import com.roudikk.navigator.core.Screen
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.parcelize.Parcelize

@Parcelize
class ListDrinksScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = requireNavigator()
        val viewModel = viewModel<ListDrinksViewModel>(
            viewModelStoreOwner = LocalNavHostViewModelStoreOwner.current
        )
        
        val model = viewModel.listDrinks.collectAsState().value

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 4.dp, top = 16.dp, end = 4.dp)
        ) {
            itemsIndexed(
                model
            ) { _, item ->
                
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .clickable {
                            navigator.navigate(
                                DrinkInfoScreen(
                                    DrinksInfoArgs(
                                        id = item.id
                                    )
                                )
                            )
                        },
                    shape = RoundedCornerShape(8.dp),
                    elevation = 4.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Gray),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        GlideImage(
                            imageModel = item.imageDrink,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(84.dp)
                                .clip(CircleShape)
                                .padding(8.dp)
                        )
                        Text(
                            text = item.nameDrink,
                            modifier = Modifier.padding(start = 6.dp),
                            fontSize = 24.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}