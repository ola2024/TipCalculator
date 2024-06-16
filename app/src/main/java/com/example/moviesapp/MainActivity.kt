package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviesapp.ui.theme.MoviesappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Myapp {
                MainContent()
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
fun MainContent() {
    Text(text = "Hello World")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoviesappTheme {
        Myapp {
            MainContent()
        }
    }
}