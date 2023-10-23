package com.ronil.moviesapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ronil.moviesapp.presentation.popular_movies_details.components.PopularMoviesDetailsScreen
import com.ronil.moviesapp.presentation.popular_movies_list.components.PopularMovieListScreen
import com.ronil.moviesapp.presentation.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.PopularMoviesScreen.route
                    ) {
                        composable(route = Screen.PopularMoviesScreen.route) {
                            PopularMovieListScreen(navController = navController)
                        }
                        composable(route = Screen.PopularMoviesDetailScreen.route + "/{movieId}"
                        ) {
                            PopularMoviesDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}

