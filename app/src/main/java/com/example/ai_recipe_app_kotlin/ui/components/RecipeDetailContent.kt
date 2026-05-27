package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RecipeDetailContent(){
    Text(text = "Recipe detail content")
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailContentPreview(){
    RecipeDetailContent()
}