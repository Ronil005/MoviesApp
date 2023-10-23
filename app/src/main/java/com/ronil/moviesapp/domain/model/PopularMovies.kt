package com.ronil.moviesapp.domain.model

data class PopularMovies(
    val results: List<Results>,
    val totalResults: Int
)
