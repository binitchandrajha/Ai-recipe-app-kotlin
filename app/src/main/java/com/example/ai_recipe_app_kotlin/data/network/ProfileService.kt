package com.example.ai_recipe_app_kotlin.data.network

import com.example.ai_recipe_app_kotlin.model.network.BaseResponse
import com.example.ai_recipe_app_kotlin.model.network.BaseResponseWithoutMessage
import com.example.ai_recipe_app_kotlin.model.network.ProfileUpdateRequest
import com.example.ai_recipe_app_kotlin.model.network.UserData
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part

const val PROFILE_BASE_PATH = "/api/profile/"

interface ProfileService {
    @PUT("$PROFILE_BASE_PATH/me")
    suspend fun updateProfile(@Body request: ProfileUpdateRequest): BaseResponse<UserData>

    @GET("$PROFILE_BASE_PATH/me")
    suspend fun getProfile(): BaseResponseWithoutMessage<UserData>

    @Multipart
    @POST("$PROFILE_BASE_PATH/me/avatar")
    suspend fun uploadProfileImage(@Part image: MultipartBody.Part): BaseResponse<UserData>
}