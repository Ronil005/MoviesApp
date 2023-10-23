package com.ronil.moviesapp.presentation

sealed class Screen(val route: String) {
    data object PopularMoviesScreen: Screen("popular_movies_screen")
    data object PopularMoviesDetailScreen: Screen("popular_movies_details_screen")
}