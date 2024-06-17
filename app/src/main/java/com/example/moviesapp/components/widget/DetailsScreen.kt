package com.example.moviesapp.components.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesapp.navigation.screenroute.ScreenRoute

@Composable
fun DetailsScreen(navController: NavController, moviesData: String?) {
    println("What is inside this: $moviesData")
    Surface(
        modifier = Modifier
            .clickable {
                navController.navigate(route = ScreenRoute.HomeScreen.name)
            }
            .fillMaxHeight()
            .fillMaxWidth(),
        shape = RectangleShape,
        color = Color.LightGray
    ) {
        moviesData?.let {
            Text(text = it, modifier = Modifier.padding(10.dp))
        }

    }

}