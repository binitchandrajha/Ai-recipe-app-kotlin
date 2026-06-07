package com.example.ai_recipe_app_kotlin.model.network

import kotlinx.serialization.Serializable

@Serializable
data class ProfileUpdateRequest(
    val name: String,
)