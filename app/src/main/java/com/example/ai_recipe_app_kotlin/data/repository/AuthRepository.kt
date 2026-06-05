package com.example.ai_recipe_app_kotlin.data.repository

import com.example.ai_recipe_app_kotlin.data.network.AuthService
import com.example.ai_recipe_app_kotlin.model.network.BaseResponse
import com.example.ai_recipe_app_kotlin.model.network.SendOtpData
import com.example.ai_recipe_app_kotlin.model.network.SendOtpRequest
import com.example.ai_recipe_app_kotlin.model.network.VerifyOtpData
import com.example.ai_recipe_app_kotlin.model.network.VerifyOtpRequest
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authService: AuthService
) {
    suspend fun sendOtp(request: SendOtpRequest): Result<BaseResponse<SendOtpData>> {
       return try {
           val response = authService.sendOtp(request)
           Result.success(response)
       } catch (e: Exception){
          Result.failure(e)
       }
    }

    suspend fun verifyOtp(request: VerifyOtpRequest) : Result<BaseResponse<VerifyOtpData>>{
        return try {
            val response = authService.verifyOtp(request)
            Result.success(response)
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}