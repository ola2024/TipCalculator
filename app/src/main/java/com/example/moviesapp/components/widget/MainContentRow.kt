package com.example.moviesapp.components.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MainContentRow(
    modifier: Modifier = Modifier,
    title: String,
    imageVector: ImageVector,
    onItemClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick.invoke() }
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
                Icon(imageVector = imageVector, contentDescription = "Image")
            }
            Text(
                text = title,
                modifier = Modifier,
                style = TextStyle(color = Color.Black),
                fontStyle = FontStyle(10),
                fontWeight = FontWeight.ExtraBold
            )
        }
    }

}

@ExperimentalMaterial3Api
@Composable
fun TopAppBarComposable(
    text:String
) {
    TopAppBar(
        title = { Text(text = text) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray),
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
    )
}