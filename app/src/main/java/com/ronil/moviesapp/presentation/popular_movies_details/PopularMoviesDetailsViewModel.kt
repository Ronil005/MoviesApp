package com.ronil.moviesapp.presentation.popular_movies_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronil.moviesapp.common.AppConstants
import com.ronil.moviesapp.common.Resource
import com.ronil.moviesapp.domain.uses_cases.get_popular_movies_details.GetPopularMoviesDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PopularMoviesDetailsViewModel @Inject constructor(
    private val getPopularMoviesDetailsUseCase: GetPopularMoviesDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(PopularMoviesDetailsState())
    val state: State<PopularMoviesDetailsState> = _state

    init {
        savedStateHandle.get<String>(AppConstants.PARAM_MOVIE_ID)?.let { movieId ->
            getPopularMoviesDetails(movieId)
        }
    }

    private fun getPopularMoviesDetails(movieId: String) {
        getPopularMoviesDetailsUseCase(movieId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PopularMoviesDetailsState(popularMoviesDetails = result.data)
                }
                is Resource.Failure -> {
                    _state.value =
                        PopularMoviesDetailsState(
                            error = result.message ?: "An unexpected error occurred"
                        )
                }
                is Resource.Loading -> {
                    _state.value = PopularMoviesDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}