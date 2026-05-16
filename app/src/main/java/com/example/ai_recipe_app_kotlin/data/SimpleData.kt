package com.example.ai_recipe_app_kotlin.data

import com.example.ai_recipe_app_kotlin.R
import com.example.ai_recipe_app_kotlin.model.OnboardingItem

object SimpleData {
    val onboardingList = listOf(
        OnboardingItem(
            title = "Welcome to AI Recipe",
            description = "Discover delicious recipes powered by AI.",
            image = R.drawable.onboarding_first
        ),
        OnboardingItem(
            title = "Easy Search",
            description = "Find recipes based on ingredients you already have.",
            image = R.drawable.onboarding_second,
        ),
        OnboardingItem(
            title = "Cook Like a Pro",
            description = "Get step-by-step instructions for every dish.",
            image = R.drawable.onboarding_third
        )
    )
}