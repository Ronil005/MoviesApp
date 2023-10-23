package com.ronil.moviesapp.data.remote.dto

import com.ronil.moviesapp.domain.model.Results

data class ResultsDto(
    val adult: Boolean?,
    val backdrop_path: String?,
    val id: Int?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?,
    val genre_ids: List<Int>?
)

fun ResultsDto.toResults(): Results {
    return Results(
        id = id,
        backdrop_path = backdrop_path,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        vote_average = vote_average,
        vote_count = vote_count,
    )
}