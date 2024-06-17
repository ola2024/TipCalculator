package com.example.moviesapp.navigation.screenroute

import java.lang.IllegalArgumentException

enum class ScreenRoute {
    HomeScreen,
    DetailsScreen;

    companion object {
        fun screenRoute(route: String?): ScreenRoute =
            when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route is not found $route")
            }
    }
}