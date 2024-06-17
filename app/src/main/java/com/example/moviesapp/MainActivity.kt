package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviesapp.components.widget.TopAppBarComposable
import com.example.moviesapp.navigation.NavigationComponent
import com.example.moviesapp.ui.theme.MoviesappTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Myapp {
                Column(horizontalAlignment = Alignment.Start) {
                    TopAppBarComposable(text = "Movies")
                    NavigationComponent()
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

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun GreetingPreview() {
    MoviesappTheme {
        Myapp {

        }
    }
}

//What Who, When Where, Why How
//a TopAppBarScrollBehavior which holds various offset values that will be applied by this top app bar to set up its height and colors[What].
// A scroll behavior is designed to work in conjunction with a scrolled content to change the top app bar appearance as the content scrolls[How].
// See