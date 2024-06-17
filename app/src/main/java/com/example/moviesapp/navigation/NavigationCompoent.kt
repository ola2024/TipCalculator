package com.example.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviesapp.components.widget.DetailsScreen
import com.example.moviesapp.components.widget.HomeScreen
import com.example.moviesapp.navigation.screenroute.ScreenRoute

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoute.HomeScreen.name) {
        composable(route = ScreenRoute.HomeScreen.name) {
            HomeScreen(navController = navController, onItemClick = {})
        }
        composable(route = ScreenRoute.DetailsScreen.name + "/{placeholder}", arguments = listOf(navArgument(name = "placeholder") { type = NavType.StringType })) {
            backStackEntry ->
            DetailsScreen(navController,backStackEntry.arguments?.getString("placeholder"))
        }

    }

}