package com.example.ai_recipe_app_kotlin.model.network

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val success: Boolean,
    val message: String,
    val data: T? = null
)

@Serializable
data class BaseResponseWithoutMessage<T>(
    val success: Boolean,
    val data: T? = null
)

@Serializable
data class BaseResponseWithoutData<T>(
    val success: Boolean,
)

@Serializable
data class SimpleResponse(
    val success: Boolean,
    val message: String
)


@Serializable
data class ErrorResponse(
    val success: Boolean,
    val message: String
)
