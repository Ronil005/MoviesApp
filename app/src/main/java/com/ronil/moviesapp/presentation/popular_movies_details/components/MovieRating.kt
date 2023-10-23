package com.ronil.moviesapp.presentation.popular_movies_details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MovieRating(rating: Double) {
    Row(modifier = Modifier.padding(horizontal = 10.dp)) {
        Icon(
            painter = painterResource(id = android.R.drawable.star_big_on),
            contentDescription = "Rating",
            tint = Color.Yellow
        )
        Text(
            text = rating.toString(),
            color = Color.Blue,
            modifier = Modifier.padding(start = 5.dp)
        )

    }
}