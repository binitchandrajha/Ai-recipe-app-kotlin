package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AppModal(
    isVisible: Boolean = false,
    onDismiss: () -> Unit = {},
    content: @Composable () -> Unit = {}
){
    if (isVisible){
        Dialog(
            onDismissRequest = onDismiss,
        ) {
            Card(
              colors = CardDefaults.cardColors(
                  containerColor = Color.White
              ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
            ){
                content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppModalPreview(){
    AppModal()
}