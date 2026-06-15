package com.example.ai_recipe_app_kotlin.model.network

import kotlinx.serialization.Serializable

@Serializable
data class GenerateRecipeRequest(
    val ingredients: List<String>
)


@Serializable
data class RecipeIngredient(    val title: String,
                                val quantity: String
)

@Serializable
data class RecipeStep(
    val step: String,
    val stepDescription: String
)

@Serializable
data class RecipeItem(
    val title: String,
    val recipeImage: String,
    val recipeDuration: String,
    val difficulty: String,
    val numberOfIngredientsUsed: Int,
    val isQuickIdea: Boolean,
    val ingredients: List<RecipeIngredient>,
    val steps: List<RecipeStep>,
    val createdAt: String,
    val updatedAt: String,
    val id: String,
    val isFavorite: Boolean
)

