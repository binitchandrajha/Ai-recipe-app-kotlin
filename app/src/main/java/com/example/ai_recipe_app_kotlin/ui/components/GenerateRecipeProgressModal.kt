package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenerateRecipeProgressModal(
    showModal : Boolean = false,
    isLoading: Boolean = false,
    onFinished: () -> Unit = {},
    onDismiss: () -> Unit = {}
){
    /** Drives the determinate progress bar based on the API call state. */
    val progress = remember { Animatable(0f) }

    LaunchedEffect(showModal, isLoading) {
        if (showModal) {
            if (isLoading) {
                // Request in flight: creep towards 90% since we can't know the exact duration.
                progress.snapTo(0f)
                progress.animateTo(0.9f, tween(durationMillis = 8000, easing = LinearOutSlowInEasing))
            } else {
                // Response arrived: fill to 100% then hand off to navigation.
                progress.animateTo(1f, tween(durationMillis = 350))
                onFinished()
            }
        }
    }

    AppModal(
        isVisible = showModal,
        onDismiss = onDismiss,
        content = {
            Column(
                modifier = Modifier.padding(
                    top = 24.dp,
                    bottom = 0.dp,
                    start = 24.dp,
                    end = 24.dp
                )
            ) {
                Text(
                    text = "Finding recipes for you...",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    text = "Mixing your Ingredients to create delicious ideas",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.size(6.dp))
                RecipeProgressIndicator(
                    currentProgress = progress.value,
                )
                Spacer(modifier = Modifier.size(6.dp))
                AppAsyncImage(
                    model = "https://img.magnific.com/free-vector/vegetables-pot-realistic-concept-with-ingredients-cooking-symbols-vector-illustration_1284-16244.jpg?semt=ais_hybrid&w=740&q=80",
                    contentDescription = "Ingredients",
                    modifier = Modifier.fillMaxWidth().background(Color.White).height(400.dp)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GenerateRecipeProgressModalPreview(){
    GenerateRecipeProgressModal()
}