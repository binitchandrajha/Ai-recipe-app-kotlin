package com.example.ai_recipe_app_kotlin.model

enum class Difficulty {
    Easy,
    Medium,
    Hard,
}

data class SavedRecipeItem (
    val id: String,
    val title: String,
    val recipeImage: String,
    val recipeDuration: String,
    val difficulty: Difficulty,
    val numberOfIngredientsUsed: Int,
)