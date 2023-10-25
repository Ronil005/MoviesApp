package com.ronil.moviesapp.presentation.popular_movies_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronil.moviesapp.common.Resource
import com.ronil.moviesapp.domain.uses_cases.get_popular_movies.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val maxMoviesCount = 10
    private val _state = mutableStateOf(PopularMoviesState())
    val state: State<PopularMoviesState> = _state

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        getPopularMoviesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = result.data?.run {
                        PopularMoviesState(popularMovies = take(maxMoviesCount))
                    } ?: kotlin.run {
                        PopularMoviesState(error = "Movies not found")
                    }
                    _state.value = PopularMoviesState()
                }

                is Resource.Failure -> {
                    _state.value =
                        PopularMoviesState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = PopularMoviesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}