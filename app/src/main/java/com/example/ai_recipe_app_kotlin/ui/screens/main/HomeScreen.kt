package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ai_recipe_app_kotlin.model.network.UserData
import com.example.ai_recipe_app_kotlin.ui.components.HomeContent
import com.example.ai_recipe_app_kotlin.utils.ToastManager
import com.example.ai_recipe_app_kotlin.viewmodel.ProfileViewModel

@Composable
fun HomeScreen(
    onRecipeClick: (String) -> Unit = {},
    profileViewModel: ProfileViewModel = hiltViewModel()
){
    var userInfo by remember {mutableStateOf<UserData?>(null)}
    val isFetchingProfileInfo by profileViewModel.isFetchingProfileInfo.collectAsState()

    LaunchedEffect(Unit) {
        profileViewModel.getUserProfile({
                profileInfo ->
            userInfo = profileInfo
        }, {
                errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }

    HomeContent(
        onRecipeClick = onRecipeClick,
        userInfo = userInfo,
        isLoading = isFetchingProfileInfo
    )
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}