package com.example.ai_recipe_app_kotlin.data.network

import com.example.ai_recipe_app_kotlin.model.network.CountedResponse
import com.example.ai_recipe_app_kotlin.model.network.IngredientData
import retrofit2.http.GET
import retrofit2.http.Query

interface IngredientService {
   @GET("/api/ingredients")
   suspend fun fetchIngredients(
      @Query("search") query: String? = null,
   ): CountedResponse<List<IngredientData>>
}