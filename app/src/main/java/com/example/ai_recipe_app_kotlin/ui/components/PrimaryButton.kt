package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.BorderStroke
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
    enabled: Boolean = true,
    containerColor: Color = DarkPrimaryColor,
    buttonContentColor: Color = Color.White.copy(alpha = 0.6f),
    disabledContainerColor: Color = DisabledPrimaryColor,
    border: BorderStroke? = null,
    btnTextColor: Color = Color.White,
    modifier: Modifier = Modifier.fillMaxWidth(),
){
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = buttonContentColor,
        ),
        border = border,
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
                text = btnText,
                color = btnTextColor
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