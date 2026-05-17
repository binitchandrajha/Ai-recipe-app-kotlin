package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.InputBorder
import com.example.ai_recipe_app_kotlin.ui.theme.TextBlack

@Composable
fun AppOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    errorMessage: String? = null
){
    val defaultModifier = Modifier
        .fillMaxWidth()

    OutlinedTextField(
        value = value,
        onValueChange = {
           onValueChange(it)
        },
        label = {
            Text(text = label)
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = InputBorder,
            unfocusedBorderColor = TextBlack,
            errorLabelColor = Color.Red,
            errorBorderColor = Color.Red
        ),
        modifier = defaultModifier.then(modifier),
        isError = isError,
        supportingText = {
            if(isError && errorMessage != null){
                Text(text = errorMessage, color = Color.Red)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AppTextField(){
    Text(text = "AppTextField")
}