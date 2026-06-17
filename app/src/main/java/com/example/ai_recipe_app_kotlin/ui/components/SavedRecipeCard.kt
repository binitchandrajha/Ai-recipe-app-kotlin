package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.data.SimpleData
import com.example.ai_recipe_app_kotlin.model.network.RecipeItem

@Composable
fun SavedRecipeCard(
    onRecipeClick: (String) -> Unit = {},
    savedRecipes: List<RecipeItem> = emptyList()
){
    val filteredSavedRecipes = savedRecipes.take(4)
    fun handleOnRecipeClick(recipeId: String){
        onRecipeClick(recipeId)
    }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Saved Recipes",
            fontWeight = FontWeight.Bold,
            )
        Spacer(modifier = Modifier.size(10.dp))
        filteredSavedRecipes.forEach { item ->
            SavedRecipeCardItem(item = item, onRecipeClick = {
                handleOnRecipeClick(
                    recipeId = it
                )
            })
            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SavedRecipeCardPreview(){
    SavedRecipeCard()
}