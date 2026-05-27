package com.example.ai_recipe_app_kotlin.model

data class QuickRecipeItem(
    val id: String,
    val recipeImage: String,
    val title: String,
    val recipeDuration: String,
    val difficulty: Difficulty,
    val isFavorite: Boolean,
)