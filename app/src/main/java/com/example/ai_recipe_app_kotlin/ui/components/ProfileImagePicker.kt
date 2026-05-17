package com.example.ai_recipe_app_kotlin.ui.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.LightGrayOutline
import com.example.ai_recipe_app_kotlin.ui.theme.MutedGreenishGray
import com.example.ai_recipe_app_kotlin.ui.theme.SoftOffWhite
import okhttp3.internal.applyConnectionSpec

@Composable
fun ProfileImagePicker(
    selectedImageUri: Uri,
    onImagePicker: ( uri: Uri) -> Unit
){
    // Photo Picker Launcher jo gallery se image pick karega
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            if (uri != null) {
                onImagePicker(uri)
            }
        }
    )

    fun launchGallery() {
        photoPickerLauncher.launch(
            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
        )
    }
    Box(){
        Box(
            modifier = Modifier.size(140.dp).clip(CircleShape).background(SoftOffWhite).border(1.dp, color = LightGrayOutline, shape = CircleShape),
            contentAlignment = Alignment.Center
        ){
            if(selectedImageUri != Uri.EMPTY){
                AsyncImage(
                    model = selectedImageUri,
                    contentDescription = "Selected Image",
                    modifier = Modifier.size(140.dp).clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Add Photo",
                    tint = MutedGreenishGray,
                    modifier = Modifier.size(100.dp)
                )
            }

        }

        Box(
          modifier = Modifier.align(Alignment.BottomEnd).size(30.dp).offset(x = (-5).dp, y = (-5).dp).clip(CircleShape).clickable(
              onClick = {
                  launchGallery()
              }
          ).background(DarkPrimaryColor),
          contentAlignment = Alignment.Center,
        ) {
            if(selectedImageUri != Uri.EMPTY){
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Add Photo",
                    tint = LightGrayOutline,
                    modifier = Modifier.size(20.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "Add Photo",
                    tint = LightGrayOutline,
                    modifier = Modifier.size(20.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun ProfileImagePickerPreview(){
    ProfileImagePicker(
        selectedImageUri = Uri.EMPTY,
        onImagePicker = {}
    )
}