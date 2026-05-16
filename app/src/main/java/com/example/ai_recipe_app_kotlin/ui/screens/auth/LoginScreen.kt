package com.example.ai_recipe_app_kotlin.ui.screens.auth

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_recipe_app_kotlin.R
import com.example.ai_recipe_app_kotlin.ui.components.AuthTopSection
import com.example.ai_recipe_app_kotlin.ui.components.PhoneNumberWithCountryPicker
import com.example.ai_recipe_app_kotlin.ui.components.PrimaryButton
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor

@Composable
fun LoginScreen(
    onLoginClick : (String) -> Unit = {}
){
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

    val isButtonEnabled = mobileNumber.length == 10 && errorMessage == null
    Scaffold(
      containerColor = PrimaryColor
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            AuthTopSection(
                title = "Login with OTP","Enter your mobile number to receive a verification code"
            )
            Column() {
                PhoneNumberWithCountryPicker(
                    mobileNumber = mobileNumber,
                    selectedCountry = selectedCountry,
                    errorMessage = errorMessage,
                    onMobileNumberChange = handleMobileNumberChange,
                    onCountrySelected = handleSelectedCountryChange,
                    onErrorMessageChange = errorMessageChange
                )

                Spacer(modifier = Modifier.size(20.dp))

                PrimaryButton(
                    btnText = "Get Code",
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                    enabled = isButtonEnabled,
                    onClick = {
                        onLoginClick(mobileNumber)
                    }
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