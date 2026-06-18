package com.example.ai_recipe_app_kotlin.ui.screens.main

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ai_recipe_app_kotlin.model.network.ProfileUpdateRequest
import com.example.ai_recipe_app_kotlin.model.network.UserData
import com.example.ai_recipe_app_kotlin.ui.components.AppAsyncImage
import com.example.ai_recipe_app_kotlin.ui.components.AppHeader
import com.example.ai_recipe_app_kotlin.ui.components.AppOutlinedTextField
import com.example.ai_recipe_app_kotlin.ui.components.OverlayLoader
import com.example.ai_recipe_app_kotlin.ui.components.PrimaryButton
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor
import com.example.ai_recipe_app_kotlin.utils.FileUtils
import com.example.ai_recipe_app_kotlin.utils.ToastManager
import com.example.ai_recipe_app_kotlin.viewmodel.ProfileViewModel

val DEFAULT_PROFILE_IMAGE: Uri =
    "https://play-lh.googleusercontent.com/dSAi-HxlHjZDB0ycNR0t3BmIqKHE9Ix1-xgvvM-zeDW-QJa3mW7A8iHR6qgB3UQlJqaRwlcEavzRGScXMYjNeg=w240-h480-rw".toUri()

@Composable
fun EditProfileScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel = hiltViewModel()
){
    val context = LocalContext.current

    var userInfo by remember { mutableStateOf<UserData?>(null) }
    var username by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var userProfileImage by remember { mutableStateOf<Uri>(DEFAULT_PROFILE_IMAGE) }

    val isFetchingProfileInfo by profileViewModel.isFetchingProfileInfo.collectAsState()
    val isUpdatingProfilePhoto by profileViewModel.isProfilePicUpdating.collectAsState()
    val isUpdatingProfile by profileViewModel.isUpdatingProfile.collectAsState()

    LaunchedEffect(Unit) {
        profileViewModel.getUserProfile({ profileInfo ->
            userInfo = profileInfo
            username = profileInfo?.name ?: ""
            phoneNumber = "${profileInfo?.countryCode ?: ""} ${profileInfo?.mobileNumber ?: ""}".trim()
            val imageUrl = FileUtils.formatImageUrl(profileInfo?.profileImage)
            userProfileImage = imageUrl?.toUri() ?: DEFAULT_PROFILE_IMAGE
        }, { errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }

    fun handleUpdateProfileImage(image: Uri){
        val multipartBody = FileUtils.getMultipartImage(context, image, "image")
        if(multipartBody != null){
            profileViewModel.updateProfilePic(multipartBody, { successMessage ->
                ToastManager.showSuccess(successMessage)
                userProfileImage = image
            }, { errorMessage ->
                ToastManager.showError(errorMessage)
            })
        }
    }

    fun onSaveClick(){
        val request = ProfileUpdateRequest(name = username)
        profileViewModel.updateProfile(request, { successMessage ->
            ToastManager.showSuccess(successMessage)
            navController.popBackStack()
        }, { errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }

    // Registers a photo picker activity launcher in single-select mode.
    val pickMedia = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        // Callback is invoked after the user selects a media item or closes the
        // photo picker.
        if (uri != null) {
            handleUpdateProfileImage(uri)
        } else {
            println("User cancelled the photo picker")
        }
    }

    Scaffold() { innerPadding ->
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = innerPadding.calculateTopPadding(), bottom = innerPadding.calculateBottomPadding())
        ){
            AppHeader(
                isFavorite = false,
                title = "Edit Profile",
                onBackClick = {
                    navController.popBackStack()
                }
            )
            Spacer(modifier = Modifier.size(10.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                AppAsyncImage(
                    model = userProfileImage,
                    contentDescription = "Profile picture",
                    modifier = Modifier.clip(CircleShape).size(70.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(10.dp))
                PrimaryButton(
                    btnText = "Change Photo",
                    btnTextColor = DarkPrimaryColor,
                    containerColor = Color.Transparent,
                    fontWeight = FontWeight.SemiBold,
                    onClick = {
                        // Launch the photo picker and let the user choose only images.
                        pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    }
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

           Column(
               modifier = Modifier.fillMaxHeight().weight(1f)
           ) {
               AppOutlinedTextField(
                   label = "Name",
                   value = username,
                   onValueChange = {
                       username = it
                   },

               )
               Spacer(modifier = Modifier.size(10.dp))
               AppOutlinedTextField(
                   label = "",
                   value = phoneNumber,
                   onValueChange = {},
                   enabled = false
               )
           }

            Spacer(modifier = Modifier.size(10.dp))
            PrimaryButton(
                btnText = "Save changes",
                enabled = username.length > 2,
                onClick = ::onSaveClick
            )
        }

        OverlayLoader(isLoading = isFetchingProfileInfo || isUpdatingProfile || isUpdatingProfilePhoto)
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview(){
    EditProfileScreen(
        navController = NavController(LocalContext.current)
    )
}
