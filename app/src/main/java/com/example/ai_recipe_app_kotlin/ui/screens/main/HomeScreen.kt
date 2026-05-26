package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ai_recipe_app_kotlin.ui.components.IngredientSearchCard
import com.example.ai_recipe_app_kotlin.ui.components.ProfileHeader
import com.example.ai_recipe_app_kotlin.ui.components.SavedRecipeCard
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor

@Composable
fun HomeScreen(){
    Scaffold(
        containerColor = PrimaryColor
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ){
            ProfileHeader()
            IngredientSearchCard()
            SavedRecipeCard()
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}