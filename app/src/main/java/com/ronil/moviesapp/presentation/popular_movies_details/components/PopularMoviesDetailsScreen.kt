package com.ronil.moviesapp.presentation.popular_movies_details.components

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ronil.moviesapp.common.APIConstant
import com.ronil.moviesapp.presentation.popular_movies_details.PopularMoviesDetailsViewModel


@Composable
fun PopularMoviesDetailsScreen(
    viewModel: PopularMoviesDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value



    Box(modifier = Modifier.fillMaxSize()) {
        state.popularMoviesDetails?.run {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)
            ) {
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    model = "${APIConstant.imageURL}$backdrop_path",
                    contentDescription = "Movie Poster image load from url",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    error = painterResource(id = R.drawable.stat_sys_warning),
                    placeholder = painterResource(id = R.drawable.stat_sys_warning)
                )

                MovieInfo(
                    title = title,
                    subtitle = overview,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                MovieRating(rating = vote_average)
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}