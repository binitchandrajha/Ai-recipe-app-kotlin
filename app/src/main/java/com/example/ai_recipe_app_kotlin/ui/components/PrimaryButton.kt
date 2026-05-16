package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.DisabledPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor


@Composable
fun PrimaryButton(
    onClick: () -> Unit = {},
    isIcon: Boolean = false,
    btnText: String? = null,
    modifier: Modifier,
    enabled: Boolean = true
){
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = DarkPrimaryColor,
            disabledContainerColor = DisabledPrimaryColor,
            disabledContentColor = Color.White.copy(alpha = 0.6f)
        ),
        enabled = enabled
    ) {
        if(isIcon){
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Submit", // Accessibility label
                tint = Color.White // Optional color styling
            )
        }
        if(btnText != null){
            Text(
                text = btnText
            )
        }
    }
}

@Preview
@Composable
fun PrimaryButtonPreview(){
    PrimaryButton(
        btnText = "Get Started",
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    )
}