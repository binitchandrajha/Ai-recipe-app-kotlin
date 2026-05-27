package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RecipeDetailScreen(){
    Text(text = "Recipe Detail")
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailPreview(){
    RecipeDetailScreen()
}