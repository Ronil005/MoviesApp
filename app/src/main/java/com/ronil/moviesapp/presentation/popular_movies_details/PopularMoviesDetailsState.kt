package com.ronil.moviesapp.presentation.popular_movies_details

import com.ronil.moviesapp.domain.model.PopularMoviesDetails

data class PopularMoviesDetailsState(
    val isLoading: Boolean = false,
    val popularMoviesDetails: PopularMoviesDetails? = null,
    val error: String = ""
)
