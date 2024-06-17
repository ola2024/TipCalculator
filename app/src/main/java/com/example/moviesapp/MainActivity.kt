package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesapp.components.widget.MainContentRow
import com.example.moviesapp.components.widget.TopAppBarComposable
import com.example.moviesapp.ui.theme.MoviesappTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Myapp {
                Column(horizontalAlignment = Alignment.Start) {
                    TopAppBarComposable(text = "Movies")
                    MainContent(onItemClick = {
                        println("Each items out: $it")
                    })
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
    ),
    onItemClick:(String) -> Unit
) {
    Column(modifier = Modifier.padding(10.dp)) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items = itemsList) {
                MainContentRow(
                    title = it,
                     onItemClick = { onItemClick.invoke(it) },
                    imageVector = Icons.Default.AccountBox
                )
            }
        }

    }

}
@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun GreetingPreview() {
    MoviesappTheme {
        Myapp {
            MainContent(onItemClick = {})
        }
    }
}

//What Who, When Where, Why How
//a TopAppBarScrollBehavior which holds various offset values that will be applied by this top app bar to set up its height and colors[What].
// A scroll behavior is designed to work in conjunction with a scrolled content to change the top app bar appearance as the content scrolls[How].
// See