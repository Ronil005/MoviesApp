package com.ronil.moviesapp.domain.uses_cases.get_popular_movies_details

import com.ronil.moviesapp.common.Resource
import com.ronil.moviesapp.data.remote.dto.toPopularMoviesDetails
import com.ronil.moviesapp.domain.model.PopularMoviesDetails
import com.ronil.moviesapp.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPopularMoviesDetailsUseCase @Inject constructor(private val repository: MoviesRepository) {

    operator fun invoke(movieId: String): Flow<Resource<PopularMoviesDetails>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetails = repository.getMoviesDetails(movieId = movieId)
            emit(Resource.Success(movieDetails.toPopularMoviesDetails()))
        } catch (exception: HttpException) {
            emit(Resource.Failure(exception.localizedMessage ?: "An unexpected error occurred"))
        } catch (exception: IOException) {
            emit(Resource.Failure("Couldn't reach server. Check your internet connection"))
        }
    }
}