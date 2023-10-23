package com.ronil.moviesapp.presentation.popular_movies_list

import com.ronil.moviesapp.domain.model.Results

data class PopularMoviesState(
    val isLoading: Boolean = false,
    val popularMovies: List<Results> = emptyList(),
    val error: String = ""
)
