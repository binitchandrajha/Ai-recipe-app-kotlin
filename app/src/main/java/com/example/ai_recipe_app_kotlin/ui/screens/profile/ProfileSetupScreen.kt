package com.example.ai_recipe_app_kotlin.ui.screens.profile

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ai_recipe_app_kotlin.model.network.ProfileUpdateRequest
import com.example.ai_recipe_app_kotlin.model.network.UserData
import com.example.ai_recipe_app_kotlin.ui.components.ProfileSetupContent
import com.example.ai_recipe_app_kotlin.utils.FileUtils
import com.example.ai_recipe_app_kotlin.utils.ToastManager
import com.example.ai_recipe_app_kotlin.viewmodel.ProfileViewModel
import androidx.core.net.toUri

@Composable
fun ProfileSetupScreen(
    onProfileSetupClick: () -> Unit = {},
    profileViewModel: ProfileViewModel = hiltViewModel()
){
    var userInfo by remember { mutableStateOf<UserData?>(null) }
    val isFetchingProfileInfo by profileViewModel.isFetchingProfileInfo.collectAsState()
    val isUpdatingProfilePhoto by profileViewModel.isProfilePicUpdating.collectAsState()
    var initialProfileImageUri: Uri by remember { mutableStateOf(Uri.EMPTY) }
    val context = LocalContext.current

    fun handleUpdateProfileImage(image: Uri){
        val multipartBody = FileUtils.getMultipartImage(context, image, "image")
        if(multipartBody != null){
           profileViewModel.updateProfilePic(multipartBody, {
                   successMessage ->
               ToastManager.showSuccess(successMessage)
               initialProfileImageUri = image
           }, {
                   errorMessage ->
               ToastManager.showError(errorMessage)
           })
        }
    }

    LaunchedEffect(Unit) {
        profileViewModel.getUserProfile({
                profileInfo ->
            userInfo = profileInfo
            val imageUrl = profileInfo?.profileImage?.replace("localhost", "10.0.2.2")
            initialProfileImageUri = imageUrl?.toUri() ?: Uri.EMPTY
        }, {
                errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }
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
        isLoading = isUpdatingProfile || isFetchingProfileInfo || isUpdatingProfilePhoto,
        initialName = userInfo?.name ?: "",
        onClick = ::onContinueClick,
        updateProfileImage = { uri ->
            handleUpdateProfileImage(uri)
        },
        initialProfileImageUri = initialProfileImageUri
    )
}

@Preview
@Composable
fun ProfileSetupScreenPreview(){
    ProfileSetupScreen()
}