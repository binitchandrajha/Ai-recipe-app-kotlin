package com.example.ai_recipe_app_kotlin.data.repository

import com.example.ai_recipe_app_kotlin.data.network.RecipesService
import com.example.ai_recipe_app_kotlin.model.network.CountedResponse
import com.example.ai_recipe_app_kotlin.model.network.GenerateRecipeRequest
import com.example.ai_recipe_app_kotlin.model.network.RecipeItem
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val recipeService: RecipesService
) {
    suspend fun generateRecipe(request: GenerateRecipeRequest) : Result<CountedResponse<List<RecipeItem>>>{
        return try {
            val response = recipeService.generateRecipes(request)
            Result.success(response)
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}