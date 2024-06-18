package com.example.moviesapp.components.widget

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moviesapp.R
import com.example.moviesapp.model.getDummyMovie
import com.example.moviesapp.navigation.screenroute.ScreenRoute

@Composable
fun DetailsScreen(
    navController: NavController,
    moviesId: String?,
) {
    val moviesList = getDummyMovie().filter { it.movieImdbID == moviesId }
    Card(
        modifier = Modifier
            .clickable {
                navController.navigate(route = ScreenRoute.HomeScreen.name)
            }
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        shape = RectangleShape,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Column(
            modifier = Modifier.padding(start = 20.dp, top = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            moviesList.firstOrNull()?.let {
                Text(text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.ExtraBold
                        )
                    ) {
                        append(stringResource(id = R.string.genre))
                    }
                    withStyle(
                        SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(it.movieGenre)
                    }
                })
                Text(text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.ExtraBold
                        )
                    ) {
                        append(stringResource(id = R.string.meta_score))
                    }
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(it.movieMetaScore)
                    }
                })
                Text(text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.ExtraBold
                        )
                    ) {
                        append(stringResource(id = R.string.writer))
                    }
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(it.movieWriter)
                    }
                })
                Text(text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.ExtraBold
                        )
                    ) {
                        append(stringResource(id = R.string.awards))
                    }
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(it.movieAwards)
                    }
                })
                Text(text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.ExtraBold
                        )
                    ) {
                        append(stringResource(id = R.string.country))
                    }
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(it.movieCountry)
                    }
                })
            }
        }

    }
}