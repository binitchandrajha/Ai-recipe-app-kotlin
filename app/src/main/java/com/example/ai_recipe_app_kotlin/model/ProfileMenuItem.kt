package com.example.ai_recipe_app_kotlin.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ProfileMenuItem(
    val menuTitle: String,
    val menuIcon: ImageVector,
    val onClick: () -> Unit
)