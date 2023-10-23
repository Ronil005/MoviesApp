package com.ronil.moviesapp.domain.uses_cases.get_popular_movies

import com.ronil.moviesapp.common.Resource
import com.ronil.moviesapp.data.remote.dto.toPopularMovies
import com.ronil.moviesapp.domain.model.PopularMovies
import com.ronil.moviesapp.domain.model.Results
import com.ronil.moviesapp.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    operator fun invoke(): Flow<Resource<List<Results>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = repository.getPopularMovies()
            emit(Resource.Success(movies.toPopularMovies().results))
        } catch (exception: HttpException) {
            emit(Resource.Failure(exception.localizedMessage ?: "An unexpected error occurred"))
        } catch (exception: IOException) {
            emit(Resource.Failure("Couldn't reach server. Check your internet connection"))
        }
    }
}