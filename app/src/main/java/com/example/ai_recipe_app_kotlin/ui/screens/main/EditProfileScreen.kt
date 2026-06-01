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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.ui.components.AppAsyncImage
import com.example.ai_recipe_app_kotlin.ui.components.AppHeader
import com.example.ai_recipe_app_kotlin.ui.components.AppOutlinedTextField
import com.example.ai_recipe_app_kotlin.ui.components.PrimaryButton
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor
import androidx.core.net.toUri

val DEFAULT_PROFILE_IMAGE: Uri =
    "https://play-lh.googleusercontent.com/dSAi-HxlHjZDB0ycNR0t3BmIqKHE9Ix1-xgvvM-zeDW-QJa3mW7A8iHR6qgB3UQlJqaRwlcEavzRGScXMYjNeg=w240-h480-rw".toUri()

@Composable
fun EditProfileScreen(){
    var username by remember { mutableStateOf("") }
    var userProfileImage by remember { mutableStateOf<Uri>(DEFAULT_PROFILE_IMAGE) }

    // Registers a photo picker activity launcher in single-select mode.
    val pickMedia = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        // Callback is invoked after the user selects a media item or closes the
        // photo picker.
        if (uri != null) {
            println("PhotoPicker -->>>> $uri")
            userProfileImage = uri
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
                title = "Edit Profile"
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
                   value = "+123456789",
                   onValueChange = {},
                   enabled = false
               )
           }

            Spacer(modifier = Modifier.size(10.dp))
            PrimaryButton(
                btnText = "Save changes"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview(){
    EditProfileScreen()
}