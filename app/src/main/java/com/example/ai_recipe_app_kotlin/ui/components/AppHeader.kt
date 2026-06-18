package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun AppHeader(
    isFavorite: Boolean = false,
    onBackClick: () -> Unit = {},
    title: String = "",
    isFavoriteIconVisible: Boolean = false,
    onSaveIconClick: () -> Unit = {},
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
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

        Box(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentAlignment = Alignment.Center
        ){
            if(!title.isEmpty()){
                Text(
                    text = title
                )
            }
        }

        if (isFavoriteIconVisible){
            IconButton(
                onClick = {
                    onSaveIconClick()
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Bookmark,
                    contentDescription = "Bookmark",
                    tint = if (isFavorite) DarkPrimaryColor else Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppHeaderPreview(){
    AppHeader(
        title = "Title",
        isFavorite = true
    )
}