package com.example.ai_recipe_app_kotlin.data.network

import com.example.ai_recipe_app_kotlin.model.network.BaseResponse
import com.example.ai_recipe_app_kotlin.model.network.ProfileUpdateRequest
import com.example.ai_recipe_app_kotlin.model.network.UserData
import retrofit2.http.Body
import retrofit2.http.PUT

const val PROFILE_BASE_PATH = "/api/profile/"

interface ProfileService {
    @PUT("$PROFILE_BASE_PATH/me")
    suspend fun updateProfile(@Body request: ProfileUpdateRequest): BaseResponse<UserData>
}