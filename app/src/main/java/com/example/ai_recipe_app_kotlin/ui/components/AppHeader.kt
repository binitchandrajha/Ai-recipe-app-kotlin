package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun AppHeader(
    isFavorite: Boolean = false,
    onBackClick: () -> Unit = {},
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = {
                onBackClick()
            }
        ) {
            Icon(
               imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "ArrowBack"
            )
        }

        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Outlined.Bookmark,
                contentDescription = "Bookmark",
                tint = if (isFavorite) DarkPrimaryColor else Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppHeaderPreview(){
    AppHeader()
}