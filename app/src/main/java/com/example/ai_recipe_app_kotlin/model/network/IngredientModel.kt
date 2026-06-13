package com.example.ai_recipe_app_kotlin.model.network

import kotlinx.serialization.Serializable

@Serializable
data class IngredientData(
    val title: String,
    val description: String,
    val ingredientImage: String,
    val createdAt: String,
    val updatedAt: String,
    val id: String
)