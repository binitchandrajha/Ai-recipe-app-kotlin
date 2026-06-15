package com.example.ai_recipe_app_kotlin.data.network

import com.example.ai_recipe_app_kotlin.model.network.CountedResponse
import com.example.ai_recipe_app_kotlin.model.network.GenerateRecipeRequest
import com.example.ai_recipe_app_kotlin.model.network.RecipeItem
import retrofit2.http.Body
import retrofit2.http.POST

const val RECIPES_BASE_PATH = "/api/recipes/"

interface RecipesService {
    @POST("$RECIPES_BASE_PATH/generate")
    suspend fun generateRecipes(@Body payload: GenerateRecipeRequest) : CountedResponse<List<RecipeItem>>
}