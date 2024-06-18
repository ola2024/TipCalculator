package com.example.moviesapp.components.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moviesapp.model.getDummyMovie

@Composable
fun DetailsScreen(
    navController: NavController,
    moviesId: String?,
) {
    val moviesList = getDummyMovie().filter { it.movieImdbID == moviesId }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RectangleShape,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            modifier = Modifier.padding(start = 20.dp, top = 40.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            moviesList.firstOrNull()?.let {
                Text(text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(it.movieGenre)
                    }
                })
            }
        }

    }
}