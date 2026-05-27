package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ai_recipe_app_kotlin.ui.components.IngredientSearchCard
import com.example.ai_recipe_app_kotlin.ui.components.ProfileHeader
import com.example.ai_recipe_app_kotlin.ui.components.QuickIdeasRecipeList
import com.example.ai_recipe_app_kotlin.ui.components.SavedRecipeCard
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor

@Composable
fun HomeScreen(){
    val scrollState = rememberScrollState()
    Scaffold(
        containerColor = PrimaryColor
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).verticalScroll(scrollState)
        ){
            ProfileHeader()
            IngredientSearchCard()
            SavedRecipeCard()
            QuickIdeasRecipeList()
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}