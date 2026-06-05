package com.example.ai_recipe_app_kotlin.utils

import com.example.ai_recipe_app_kotlin.model.network.ErrorResponse
import kotlinx.serialization.json.Json
import retrofit2.HttpException

object NetworkUtils {
    private val json = Json { ignoreUnknownKeys = true }

    fun parseError(e: Throwable): String {
        return when (e) {
            is HttpException -> {
                try {
                    val errorBody = e.response()?.errorBody()?.string()
                    val errorResponse = errorBody?.let {
                        json.decodeFromString<ErrorResponse>(it)
                    }
                    errorResponse?.message ?: "An unexpected server error occured"
                } catch (ex: Exception) {
                    "Server Error ${e.code()}"
                }
            }
            else -> e.localizedMessage ?: "An unexpected error occured"
        }
    }
}