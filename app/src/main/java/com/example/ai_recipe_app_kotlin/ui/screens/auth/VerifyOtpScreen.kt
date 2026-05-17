package com.example.ai_recipe_app_kotlin.ui.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.ui.components.AuthTopSection
import com.example.ai_recipe_app_kotlin.ui.components.OtpInput
import com.example.ai_recipe_app_kotlin.ui.components.PrimaryButton
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor
import kotlinx.coroutines.delay

@Composable
fun VerifyOtpScreen(
    phoneNumber: String = "+977 1234567890",
    onVerifyClick: () -> Unit = {},
    onResendClick: () -> Unit = {}
) {
    var otpText by remember { mutableStateOf("") }
    var timeLeft by remember { mutableIntStateOf(30) }
    var isResendEnabled by remember { mutableStateOf(false) }

    LaunchedEffect(timeLeft) {
        if (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        } else {
            isResendEnabled = true
        }
    }

    Scaffold(
        containerColor = PrimaryColor
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AuthTopSection(
                title = "OTP verification",
                description = "Enter the 6-digit code sent to $phoneNumber"
            )

            OtpInput(
                otpText = otpText,
                onOtpChange = { otpText = it }
            )

            Spacer(modifier = Modifier.size(30.dp))

            PrimaryButton(
                btnText = "Verify OTP",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                enabled = otpText.length == 6,
                onClick = onVerifyClick
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = buildAnnotatedString {
                    append("Didn't receive code? ")
                    if (isResendEnabled) {
                        withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                            append("Resend Again")
                        }
                    } else {
                        withStyle(style = SpanStyle(color = Color.Gray)) {
                            append("Resend in ${timeLeft}s")
                        }
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .clickable(enabled = isResendEnabled) {
                        timeLeft = 30
                        isResendEnabled = false
                        onResendClick()
                    }
            )
        }
    }
}

@Preview
@Composable
fun VerifyOtpScreenPreview(){
    VerifyOtpScreen()
}