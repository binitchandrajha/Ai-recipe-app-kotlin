package com.example.ai_recipe_app_kotlin.data.repository

import com.example.ai_recipe_app_kotlin.data.network.RecipesService
import com.example.ai_recipe_app_kotlin.model.network.BaseResponseWithoutMessage
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

    suspend fun getRecipeDetail(id: String) : Result<BaseResponseWithoutMessage<RecipeItem>>{
        return try {
            val response = recipeService.getRecipeById(id)
            Result.success(response)
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    suspend fun getRecipesQuickIdeas(): Result<CountedResponse<List<RecipeItem>>> {
        return try {
            val response = recipeService.getRecipesQuickIdeas()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getSavedRecipes(): Result<CountedResponse<List<RecipeItem>>> {
        return try {
            val response = recipeService.getSavedRecipes()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}