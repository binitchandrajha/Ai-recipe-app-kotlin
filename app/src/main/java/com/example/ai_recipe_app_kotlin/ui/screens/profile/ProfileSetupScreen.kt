package com.example.ai_recipe_app_kotlin.ui.screens.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ai_recipe_app_kotlin.model.network.ProfileUpdateRequest
import com.example.ai_recipe_app_kotlin.ui.components.ProfileSetupContent
import com.example.ai_recipe_app_kotlin.utils.ToastManager
import com.example.ai_recipe_app_kotlin.viewmodel.ProfileViewModel

@Composable
fun ProfileSetupScreen(
    onProfileSetupClick: () -> Unit = {},
    profileViewModel: ProfileViewModel = hiltViewModel()
){
    val isUpdatingProfile by profileViewModel.isUpdatingProfile.collectAsState()
    fun onContinueClick(name: String){
        val request = ProfileUpdateRequest(
            name = name
        )
        profileViewModel.updateProfile(request, {
                successMessage ->
            ToastManager.showSuccess(successMessage)
            onProfileSetupClick()
        }, {
                errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }
    ProfileSetupContent(
        isLoading = isUpdatingProfile,
        onClick = ::onContinueClick
    )
}

@Preview
@Composable
fun ProfileSetupScreenPreview(){
    ProfileSetupScreen()
}