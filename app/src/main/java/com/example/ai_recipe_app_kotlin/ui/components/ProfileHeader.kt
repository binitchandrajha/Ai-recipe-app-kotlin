package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfileHeader(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ){
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Hello, Alex",
                fontWeight = FontWeight.Bold,
                )
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = "What will you work on today?")
        }
        AppAsyncImage(
            model = "https://play-lh.googleusercontent.com/dSAi-HxlHjZDB0ycNR0t3BmIqKHE9Ix1-xgvvM-zeDW-QJa3mW7A8iHR6qgB3UQlJqaRwlcEavzRGScXMYjNeg=w240-h480-rw",
            contentDescription = "Profile picture",
            modifier = Modifier.clip(CircleShape).size(50.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileHeaderPreview(){
    ProfileHeader()
}