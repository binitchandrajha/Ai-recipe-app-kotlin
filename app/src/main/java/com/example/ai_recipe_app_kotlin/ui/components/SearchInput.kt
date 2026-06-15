package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun SearchInput(
    value: String,
    onValueChange: (String) -> Unit,
    onFocusChange: (focusStatus: Boolean) -> Unit = {},
    onMicClick: () -> Unit = {},
    placeholder: String = "Search ingredients"
){
    TextField(
        value = value,
        modifier = Modifier.fillMaxWidth()
            .onFocusChanged{
                focusState -> onFocusChange(focusState.isFocused)
            }
            .border(
            1.dp,
            Color.LightGray,
            shape = RoundedCornerShape(50.dp)
        ),
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeholder)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        trailingIcon = {
            Box(
               modifier = Modifier.background(DarkPrimaryColor, shape = RoundedCornerShape(50.dp)).height(35.dp).width(35.dp).clickable{
                   onMicClick()
               },
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Default.Mic,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )

    )
}

@Preview(showBackground = true)
@Composable
fun SearchInputPreview(){
    SearchInput(
        value = "",
        onValueChange = {}
    )
}