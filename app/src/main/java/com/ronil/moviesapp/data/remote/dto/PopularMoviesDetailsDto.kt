package com.ronil.moviesapp.data.remote.dto

import com.ronil.moviesapp.domain.model.PopularMoviesDetails

data class PopularMoviesDetailsDto(
    val adult: Boolean?,
    val backdrop_path: String?,
    val belongs_to_collection: BelongsToCollectionDto?,
    val budget: Int?,
    val genres: List<GenreDto>?,
    val homepage: String?,
    val id: Int?,
    val imdb_id: String?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val production_companies: List<ProductionCompanyDto>?,
    val production_countries: List<ProductionCountryDto>?,
    val release_date: String?,
    val revenue: Int?,
    val runtime: Int?,
    val spoken_languages: List<SpokenLanguageDto>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
)

fun PopularMoviesDetailsDto.toPopularMoviesDetails(): PopularMoviesDetails {
    return PopularMoviesDetails(
        backdrop_path = backdrop_path.orEmpty(),
        original_language = original_language.orEmpty(),
        original_title = original_title.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        poster_path = poster_path.orEmpty(),
        release_date = release_date.orEmpty(),
        revenue = revenue ?: 0,
        runtime = runtime ?: 0,
        status = status.orEmpty(),
        title = title.orEmpty(),
        vote_average = vote_average ?: 0.0,
        vote_count = vote_count ?: 0
    )
}