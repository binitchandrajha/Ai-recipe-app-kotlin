package com.example.ai_recipe_app_kotlin.data.repository

import com.example.ai_recipe_app_kotlin.data.network.ProfileService
import com.example.ai_recipe_app_kotlin.model.network.BaseResponse
import com.example.ai_recipe_app_kotlin.model.network.ProfileUpdateRequest
import com.example.ai_recipe_app_kotlin.model.network.UserData
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val profileService: ProfileService,
) {
    suspend fun updateProfile(request: ProfileUpdateRequest) : Result<BaseResponse<UserData>>{
        return try {
            val response = profileService.updateProfile(request)
            Result.success(response)
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}