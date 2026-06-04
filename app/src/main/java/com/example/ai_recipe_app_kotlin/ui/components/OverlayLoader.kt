package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun OverlayLoader(
    isLoading: Boolean = true
){
    if(isLoading){
        Dialog(
            onDismissRequest = {}
        ) {
            Box(
                modifier = Modifier.size(100.dp).background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = DarkPrimaryColor)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OverlayLoaderPreview(){
    OverlayLoader()
}