package com.ronil.moviesapp.domain.model

data class Results(
    val id: Int?,
    val backdrop_path: String?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val vote_average: Double?,
    val vote_count: Int?,
)
