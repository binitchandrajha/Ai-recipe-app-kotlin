package com.example.ai_recipe_app_kotlin.ui.screens.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ai_recipe_app_kotlin.ui.components.LoginContent
import com.example.ai_recipe_app_kotlin.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    onLoginClick : (String) -> Unit = {},
    loginViewModel: LoginViewModel = hiltViewModel()
){
    val isSendingOtp by loginViewModel.isSendingOtp.collectAsState()
      LoginContent(
          isLoading = isSendingOtp,
          onLoginClick = { payload ->
              loginViewModel.onSendOtpClick(payload, {
                  onLoginClick(payload.mobileNumber)
              })
          }
      )
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(
        onLoginClick = {},
    )
}