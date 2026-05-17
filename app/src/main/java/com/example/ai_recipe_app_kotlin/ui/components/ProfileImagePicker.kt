package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.LightGrayOutline
import com.example.ai_recipe_app_kotlin.ui.theme.MutedGreenishGray
import com.example.ai_recipe_app_kotlin.ui.theme.SoftOffWhite

@Composable
fun ProfileImagePicker(){
    Box(){
        Box(
            modifier = Modifier.size(140.dp).clip(CircleShape).background(SoftOffWhite).border(1.dp, color = LightGrayOutline, shape = CircleShape),
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Add Photo",
                tint = MutedGreenishGray,
                modifier = Modifier.size(100.dp)
            )
        }

        Box(
          modifier = Modifier.align(Alignment.BottomEnd).size(30.dp).offset(x = (-5).dp, y = (-5).dp).clip(CircleShape).background(DarkPrimaryColor),
          contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = "Add Photo",
                tint = LightGrayOutline,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview
@Composable
fun ProfileImagePickerPreview(){
    ProfileImagePicker()
}