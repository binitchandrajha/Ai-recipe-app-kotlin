package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ai_recipe_app_kotlin.ui.components.AppHeader
import com.example.ai_recipe_app_kotlin.ui.components.RecipeDetailContent
import com.example.ai_recipe_app_kotlin.ui.theme.LightPrimaryColor

@Composable
fun RecipeDetailScreen(){
    Scaffold(
        containerColor = LightPrimaryColor,
    ){ innerPadding ->
        Column(
            modifier = Modifier.systemBarsPadding()
        ) {
            AppHeader()
            RecipeDetailContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailPreview(){
    RecipeDetailScreen()
}