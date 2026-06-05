package com.example.ai_recipe_app_kotlin.data.network

import com.example.ai_recipe_app_kotlin.model.network.BaseResponse
import com.example.ai_recipe_app_kotlin.model.network.SendOtpData
import com.example.ai_recipe_app_kotlin.model.network.SendOtpRequest
import com.example.ai_recipe_app_kotlin.model.network.VerifyOtpData
import com.example.ai_recipe_app_kotlin.model.network.VerifyOtpRequest
import retrofit2.http.Body
import retrofit2.http.POST

const val AUTH_BASE_PATH = "/api/auth/"

interface AuthService {
   @POST("$AUTH_BASE_PATH/send-otp")
   suspend fun sendOtp(@Body request: SendOtpRequest) : BaseResponse<SendOtpData>

   @POST("$AUTH_BASE_PATH/verify-otp")
   suspend fun verifyOtp(@Body request: VerifyOtpRequest) : BaseResponse<VerifyOtpData>
}