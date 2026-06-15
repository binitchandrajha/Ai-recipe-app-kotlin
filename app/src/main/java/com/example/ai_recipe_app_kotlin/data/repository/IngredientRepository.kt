package com.example.ai_recipe_app_kotlin.data.repository

import com.example.ai_recipe_app_kotlin.data.network.IngredientService
import com.example.ai_recipe_app_kotlin.model.network.CountedResponse
import com.example.ai_recipe_app_kotlin.model.network.IngredientData
import javax.inject.Inject

class IngredientRepository @Inject constructor(
    private val ingredientService: IngredientService
) {
    suspend fun fetchIngredients(query: String? = null): Result<CountedResponse<List<IngredientData>>> {
        return try {
            val response = ingredientService.fetchIngredients(query)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}