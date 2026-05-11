package com.example.ai_recipe_app_kotlin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ai_recipe_app_kotlin.ui.screens.onboarding.OnboardingScreen

@Composable
fun AppNavHost(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Onboarding){
        composable<Screen.Onboarding>{
            OnboardingScreen()
        }
    }
}