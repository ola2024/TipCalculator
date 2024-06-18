package com.example.moviesapp.components.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.moviesapp.model.MovieItem
import com.example.moviesapp.model.getDummyMovie
import com.example.moviesapp.navigation.screenroute.ScreenRoute

@Composable
fun MainContentRow(
    modifier: Modifier = Modifier,
    title: MovieItem,
    onItemClick: () -> Unit
) {
    val expanded = remember {
        mutableStateOf(false)
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick.invoke() }
            .padding(2.dp)
            .size(100.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(80.dp),
                shape = CircleShape
            ) {
                Image(
                    painter = rememberImagePainter(data = title.movieImages[0], builder = {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }),
                    contentDescription = "images"
                )
            }
            Column(modifier = Modifier) {
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    ) {
                        append("Title : ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 13.sp
                        )
                    ) {
                        append(title.movieTitle)
                    }
                }, modifier = Modifier.clickable { expanded.value = !expanded.value })
                AnimatedVisibility(visible = expanded.value) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            ) {
                                append("Rating: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontStyle = FontStyle.Normal,
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 13.sp
                                )
                            ) {
                                append(title.movieRate)
                            }
                        })
                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            ) {
                                append("Year: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontStyle = FontStyle.Normal,
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 13.sp
                                )
                            ) {
                                append(title.movieYear)
                            }
                        })
                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            ) {
                                append("Released: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontStyle = FontStyle.Normal,
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 13.sp
                                )
                            ) {
                                append(title.movieReleased)
                            }
                        })
                    }
                }
            }
        }

    }
}


@Composable
fun HomeScreen(
    itemsList: List<MovieItem> = getDummyMovie(),
    navController: NavController,
    onItemClick: (String) -> Unit
) {
    Column(modifier = Modifier.padding(10.dp)) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items = itemsList) {
                MainContentRow(
                    title = it,
                ) {
                    navController.navigate(route = ScreenRoute.DetailsScreen.name + "/${it.movieImdbID}")
                }
            }
        }
    }

}

@ExperimentalMaterial3Api
@Composable
fun TopAppBarComposable(
    title: String,
    actions: @Composable () -> Unit = {}
) {
    TopAppBar(
        {
            CenterAlignedTopAppBar(
                title = { Text(text = title) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent),
                scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            )
        },
        actions = { actions() }
    )
}