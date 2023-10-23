package com.ronil.moviesapp.data.remote

import com.ronil.moviesapp.common.APIConstant
import com.ronil.moviesapp.data.remote.dto.PopularMoviesDetailsDto
import com.ronil.moviesapp.data.remote.dto.PopularMoviesDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {
    @GET(APIConstant.popularMovies)
    suspend fun getPopularMovies(): PopularMoviesDto

    @GET(APIConstant.prefix + "/{movieId}")
    suspend fun getMovieDetails(
        @Path(value = "movieId") movieId: String
    ): PopularMoviesDetailsDto

}