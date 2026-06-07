package com.example.ai_recipe_app_kotlin.ui.components

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor

@Composable
fun ProfileSetupContent(
    isLoading: Boolean = false,
    onClick: (name: String) -> Unit = {},
    initialName: String = ""
){
    var name by remember { mutableStateOf(initialName) }
    var nameFeildErrorMessage by remember { mutableStateOf("") }
    var profileImageUri: Uri by remember { mutableStateOf(Uri.EMPTY) }

    LaunchedEffect(initialName) {
        name = initialName
    }
    Scaffold(
        containerColor = PrimaryColor,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(horizontal = 24.dp , vertical = innerPadding.calculateTopPadding()).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Set up your profile",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Add your name and profile photo so that others can recognize you",
                fontSize = 14.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.size(30.dp))
            ProfileImagePicker(
                selectedImageUri = profileImageUri,
                onImagePicker = { uri: Uri ->
                    profileImageUri = uri
                }
            )
            Spacer(modifier = Modifier.size(20.dp))
            AppOutlinedTextField(
                value = name,
                onValueChange = { input ->
                    if(input.length > 2){
                        nameFeildErrorMessage = ""
                    }else{
                        nameFeildErrorMessage = "Name should be more than 2 characters"
                    }
                    name = input
                },
                label = "Name",
                errorMessage = nameFeildErrorMessage,
                isError = nameFeildErrorMessage != ""
            )
            Spacer(modifier = Modifier.size(30.dp))
            PrimaryButton(
                btnText = "Continue",
                enabled = nameFeildErrorMessage == "",
                onClick = {onClick(name)}
            )

            OverlayLoader(isLoading = isLoading)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileSetupContentPreview(){
    ProfileSetupContent()
}