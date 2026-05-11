package com.example.ai_recipe_app_kotlin.ui.navigation

import kotlinx.serialization.Serializable

sealed class Screen() {
    @Serializable object Onboarding : Screen()
}