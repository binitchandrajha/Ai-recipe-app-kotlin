package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun ConfirmationPopupModal(
    showModal: Boolean = true,
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {},
    confirmationText: String
){
    AppModal(
        isVisible = showModal,
        onDismiss = onDismiss,
        content = {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = confirmationText, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.size(16.dp))
                Row(

                ) {
                    PrimaryButton(
                       btnText = "No",
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        containerColor = Color.Transparent,
                        border = BorderStroke(1.dp, DarkPrimaryColor),
                        btnTextColor = DarkPrimaryColor,
                        onClick = onDismiss
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    PrimaryButton(
                       btnText = "Yes",
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        onClick = onConfirm
                    )
                }
            }
        },

    )
}

@Preview(showBackground = true)
@Composable
fun ConfirmationPopupModalPreview(){
    ConfirmationPopupModal(
        confirmationText = "Are you sure?"
    )
}