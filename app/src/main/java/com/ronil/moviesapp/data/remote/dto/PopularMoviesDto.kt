package com.ronil.moviesapp.data.remote.dto

import com.ronil.moviesapp.domain.model.PopularMovies

data class PopularMoviesDto(
    val results: List<ResultsDto>?,
    val page: Int?,
    val totalPages: Int?,
    val totalResults: Int?
)

fun PopularMoviesDto.toPopularMovies(): PopularMovies {
    return PopularMovies(
        results = results?.map { it.toResults() }.orEmpty(),
        totalResults = totalResults ?: 0
    )
}
