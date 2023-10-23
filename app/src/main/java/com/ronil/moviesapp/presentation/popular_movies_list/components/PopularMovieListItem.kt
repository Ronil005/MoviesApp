package com.ronil.moviesapp.presentation.popular_movies_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ronil.moviesapp.common.APIConstant
import com.ronil.moviesapp.domain.model.Results

@Composable
fun PopularMovieListItem(
    popularMovie: Results,
    onItemClick: (Results) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onItemClick.invoke(popularMovie)
        }) {

        AsyncImage(
            contentScale = ContentScale.Crop,
            model = APIConstant.imageURL + popularMovie.backdrop_path,
            contentDescription = "Movie Poster image load from url",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick.invoke(popularMovie)
                },
            error = painterResource(id = android.R.drawable.stat_sys_warning),
            placeholder = painterResource(id = android.R.drawable.stat_sys_warning)

            )

    }

}