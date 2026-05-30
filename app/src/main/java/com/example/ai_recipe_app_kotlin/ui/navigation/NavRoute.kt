package com.example.ai_recipe_app_kotlin.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Onboarding : Screen()

    @Serializable
    data class Login(val phoneNumber: String? = null) : Screen()

    @Serializable
    data class VerifyOtp(val phoneNumber: String) : Screen()
    
    @Serializable
    data class ProfileSetup(val phoneNumber: String? = null) : Screen()

    @Serializable
    data object Main: Screen()

    @Serializable
    data object Home : Screen()

    @Serializable
    data object Saved : Screen()

    @Serializable
    data object Profile : Screen()

    @Serializable
    data class RecipeDetail(val recipeId: String) : Screen()
}

