package com.example.ai_recipe_app_kotlin.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import com.example.ai_recipe_app_kotlin.model.BottomNavItem
import com.example.ai_recipe_app_kotlin.ui.navigation.Screen

val BottomNavItems = listOf(
    BottomNavItem(
        label = "Home",
        icon = Icons.Filled.Home,
        route = Screen.Home
    ),
    BottomNavItem(
        label = "Saved",
        icon = Icons.Filled.Bookmark,
        route = Screen.Saved
    ),
    BottomNavItem(
        label = "Profile",
        icon = Icons.Filled.AccountCircle,
        route = Screen.Profile
    )
)