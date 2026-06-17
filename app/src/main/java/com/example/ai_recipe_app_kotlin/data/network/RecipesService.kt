package com.example.ai_recipe_app_kotlin.data.network

import com.example.ai_recipe_app_kotlin.model.network.BaseResponseWithoutMessage
import com.example.ai_recipe_app_kotlin.model.network.CountedResponse
import com.example.ai_recipe_app_kotlin.model.network.GenerateRecipeRequest
import com.example.ai_recipe_app_kotlin.model.network.RecipeItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

const val RECIPES_BASE_PATH = "/api/recipes/"

interface RecipesService {
    @POST("$RECIPES_BASE_PATH/generate")
    suspend fun generateRecipes(@Body payload: GenerateRecipeRequest) : CountedResponse<List<RecipeItem>>

    @GET("$RECIPES_BASE_PATH{id}")
    suspend fun getRecipeById(@Path("id") id: String) : BaseResponseWithoutMessage<RecipeItem>

    @GET(value = "$RECIPES_BASE_PATH/quick-ideas")
    suspend fun getRecipesQuickIdeas() : CountedResponse<List<RecipeItem>>
}