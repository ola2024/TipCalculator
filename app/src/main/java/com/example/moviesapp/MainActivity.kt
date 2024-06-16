package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesapp.ui.theme.MoviesappTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Myapp {
                Column(horizontalAlignment = Alignment.Start) {
                    TopAppBarComposable()
                    MainContent()
                }
            }

        }
    }
}

@Composable
fun Myapp(content: @Composable () -> Unit) {
    MoviesappTheme {
        content()
    }
}

@ExperimentalMaterial3Api
@Composable
fun TopAppBarComposable() {
    TopAppBar(
        title = { Text(text = "Movies") },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray),
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
    )
}

@Composable
fun MainContent(
    itemsList: List<String> = listOf(
        "Room To Go",
        "Blad Runner",
        "Vikings Room",
        "Day of the Jacker",
        "Woman Go To School",
        "Room To Go",
        "Blad Runner",
        "Vikings Room",
        "Day of the Jacker",
        "Woman Go To School",
        "Room To Go",
        "Blad Runner",
        "Vikings Room",
        "Day of the Jacker",
        "Woman Go To School",
        "Room To Go",
        "Blad Runner",
        "Vikings Room",
        "Day of the Jacker",
        "Woman Go To School"
    )
) {
    Column(modifier = Modifier.padding(10.dp)) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items = itemsList) {
                MainContentRow(movies = it) { movie ->
                    println("what is here : $movie")
                }
            }
        }

    }

}

@Composable
fun MainContentRow(movies: String, onItemClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(movies)
            }
            .padding(2.dp)
            .size(100.dp),
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
                    .size(100.dp),
                color = Color.LightGray
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Image")
            }
            Text(
                text = movies.trim(),
                modifier = Modifier,
                style = TextStyle(color = Color.Black),
                fontStyle = FontStyle(10),
                fontWeight = FontWeight.ExtraBold
            )
        }
    }

}

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun GreetingPreview() {
    MoviesappTheme {
        Myapp {
            MainContent()
        }
    }
}

//What Who, When Where, Why How
//a TopAppBarScrollBehavior which holds various offset values that will be applied by this top app bar to set up its height and colors[What].
// A scroll behavior is designed to work in conjunction with a scrolled content to change the top app bar appearance as the content scrolls[How].
// See