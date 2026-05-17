package com.example.ai_recipe_app_kotlin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ai_recipe_app_kotlin.ui.screens.auth.LoginScreen
import com.example.ai_recipe_app_kotlin.ui.screens.auth.VerifyOtpScreen
import com.example.ai_recipe_app_kotlin.ui.screens.onboarding.OnboardingScreen
import com.example.ai_recipe_app_kotlin.ui.screens.profile.ProfileSetupScreen
import com.example.ai_recipe_app_kotlin.viewmodel.OnboardingViewModel

@Composable
fun AppNavHost(){
    val navController = rememberNavController()
    val onboardingViewModel: OnboardingViewModel = hiltViewModel()

    val isOnboardingCompleted by onboardingViewModel.isOnboardingCompleted.collectAsState()
    NavHost(navController = navController, startDestination = if(isOnboardingCompleted) Screen.Login() else Screen.Onboarding){
        composable<Screen.Onboarding>{
            OnboardingScreen(
              onGetStartedClick = {
                  navController.navigate(Screen.Login()) {
                      popUpTo(Screen.Onboarding) {
                          inclusive = true
                      }
                  }
                  onboardingViewModel.saveOnboardingFinished()
              }
            )
        }
        composable<Screen.Login> {
            LoginScreen(
                onLoginClick = { phoneNumber ->
                    navController.navigate(Screen.VerifyOtp(phoneNumber))
                }
            )
        }
        composable<Screen.VerifyOtp> { backStackEntry ->
            val verifyOtp: Screen.VerifyOtp = backStackEntry.toRoute()
            VerifyOtpScreen(
                phoneNumber = verifyOtp.phoneNumber,
                onVerifyClick = {
                    // Navigate to Home or next screen
                    navController.navigate(Screen.ProfileSetup(phoneNumber = verifyOtp.phoneNumber))
                }
            )
        }
        composable<Screen.ProfileSetup> {
            ProfileSetupScreen()
        }
    }
}