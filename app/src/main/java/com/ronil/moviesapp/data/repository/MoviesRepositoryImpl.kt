package com.ronil.moviesapp.data.repository

import com.ronil.moviesapp.data.remote.MoviesApi
import com.ronil.moviesapp.data.remote.dto.PopularMoviesDetailsDto
import com.ronil.moviesapp.data.remote.dto.PopularMoviesDto
import com.ronil.moviesapp.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesApi: MoviesApi) : MoviesRepository {

    override suspend fun getPopularMovies(): PopularMoviesDto {
        return moviesApi.getPopularMovies()
    }

    override suspend fun getMoviesDetails(movieId: String): PopularMoviesDetailsDto {
        return moviesApi.getMovieDetails(movieId = movieId)
    }

}