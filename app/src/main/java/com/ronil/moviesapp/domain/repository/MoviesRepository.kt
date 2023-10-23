package com.ronil.moviesapp.domain.repository

import com.ronil.moviesapp.data.remote.dto.PopularMoviesDetailsDto
import com.ronil.moviesapp.data.remote.dto.PopularMoviesDto

interface MoviesRepository {

    suspend fun getPopularMovies(): PopularMoviesDto

    suspend fun getMoviesDetails(movieId: String): PopularMoviesDetailsDto
}