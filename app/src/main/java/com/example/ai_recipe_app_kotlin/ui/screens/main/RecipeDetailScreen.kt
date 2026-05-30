package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.ui.components.AppAsyncImage
import com.example.ai_recipe_app_kotlin.ui.components.AppHeader
import com.example.ai_recipe_app_kotlin.ui.components.RecipeDetailContent
import com.example.ai_recipe_app_kotlin.ui.theme.LightPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.SoftWhite


@Composable
fun RecipeDetailScreen(){
    val scrollState = rememberScrollState()
    Scaffold(
        containerColor = SoftWhite,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier.clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)).background(LightPrimaryColor).height(400.dp).
                padding(top = innerPadding.calculateTopPadding())
            ) {
                AppHeader()
                AppAsyncImage(
                    model = "https://img.magnific.com/free-photo/penne-pasta-tomato-sauce-with-chicken-tomatoes-wooden-table_2829-19744.jpg?semt=ais_hybrid&w=740&q=80",
                    contentDescription = "Chicken Biryani",
                    modifier = Modifier.fillMaxWidth().fillMaxHeight().weight(1f).padding(start = 32.dp, end = 32.dp, top = 16.dp),
                    contentScale = ContentScale.Crop,
                )
            }
            Column() {
                RecipeDetailContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailPreview(){
    RecipeDetailScreen()
}