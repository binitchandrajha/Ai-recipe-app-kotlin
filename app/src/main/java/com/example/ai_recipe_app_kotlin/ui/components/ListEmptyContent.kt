package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun ListEmptyContent(){
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        AppAsyncImage(
            model = "https://cdn11.bigcommerce.com/s-9eixvcjw2b/images/stencil/1280x1280/products/4792/134312/0722845_1__56253.1754510003.jpg?c=1",
            contentDescription = "No recipe found",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxWidth().height(300.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "No saved recipes yet",
            fontSize = 16.sp,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.size(14.dp))
        Text(
            text = "Save your favorite recipes and find them here anytime",
            fontSize = 14.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Medium,
        )
        Spacer(modifier = Modifier.size(16.dp))
        PrimaryButton(
            btnText = "Generate Recipes"
        )
        Spacer(modifier = Modifier.size(16.dp))
        PrimaryButton(
            btnText = "Browse Recipes",
            containerColor = Color.Transparent,
            border = BorderStroke(2.dp, DarkPrimaryColor),
            btnTextColor = DarkPrimaryColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ListEmptyContentPreview(){
    ListEmptyContent()
}