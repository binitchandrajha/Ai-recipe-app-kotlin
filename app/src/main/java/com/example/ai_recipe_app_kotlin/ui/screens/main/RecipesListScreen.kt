package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ai_recipe_app_kotlin.model.network.RecipeItem
import com.example.ai_recipe_app_kotlin.ui.components.AppHeader
import com.example.ai_recipe_app_kotlin.ui.components.ListEmptyContent
import com.example.ai_recipe_app_kotlin.ui.components.RecipeListItem
import com.example.ai_recipe_app_kotlin.ui.navigation.Screen
import com.example.ai_recipe_app_kotlin.ui.theme.SoftWhite

@Composable
fun RecipesListScreen(
    navController: NavController,
    recipes: List<RecipeItem>
){
    Scaffold(
        containerColor = SoftWhite,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            AppHeader(
                title = "Recipes",
                onBackClick = {
                    navController.popBackStack()
                }
            )

            if (recipes.isEmpty()) {
                ListEmptyContent()
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                ) {
                    items(recipes) { recipe ->
                        RecipeListItem(
                            item = recipe,
                            onClick = {
                                navController.navigate(Screen.RecipeDetail(recipe.id))
                            }
                        )
                        Spacer(modifier = Modifier.size(12.dp))
                    }
                }
            }
        }
    }
}
