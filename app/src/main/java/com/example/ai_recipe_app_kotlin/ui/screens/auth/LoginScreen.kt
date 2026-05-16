package com.example.ai_recipe_app_kotlin.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_recipe_app_kotlin.R
import com.example.ai_recipe_app_kotlin.ui.components.PhoneNumberWithCountryPicker
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor

@Composable
fun LoginScreen(){
    var mobileNumber by remember { mutableStateOf("") }
    var selectedCountry by remember { mutableStateOf("NP") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val handleMobileNumberChange = { input: String ->
       mobileNumber = input
    }
    val handleSelectedCountryChange = { input: String ->
        selectedCountry = input
    }
    val errorMessageChange = { input : String? ->
        errorMessage = input
    }
    Scaffold(
      containerColor = PrimaryColor
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.app_main_image),
                    contentDescription = "Main image",
                    modifier = Modifier.height(300.dp).width(300.dp),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login with OTP",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Enter your mobile number to receive a verification code",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                    )
            }
            Spacer(modifier = Modifier.size(24.dp))
            Column() {
                PhoneNumberWithCountryPicker(
                    mobileNumber = mobileNumber,
                    selectedCountry = selectedCountry,
                    errorMessage = errorMessage,
                    onMobileNumberChange = handleMobileNumberChange,
                    onCountrySelected = handleSelectedCountryChange,
                    onErrorMessageChange = errorMessageChange
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}