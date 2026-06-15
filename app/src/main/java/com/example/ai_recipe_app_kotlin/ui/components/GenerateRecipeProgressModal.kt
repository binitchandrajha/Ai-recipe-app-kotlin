package com.example.ai_recipe_app_kotlin.ui.components

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun GenerateRecipeProgressModal(
    showModal : Boolean = false,
    currentProgress: Float = 0f,
    onDismiss: () -> Unit = {}
){
    /** Iterate the progress value */
    suspend fun loadProgress(updateProgress: (Float) -> Unit){
        for (i in 1..100){
            updateProgress(i.toFloat() / 100f)
            delay(100)
        }
    }

    LaunchedEffect(showModal) {
        if (showModal) {
            loadProgress { progress ->
//                currentProgress = progress
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
                    currentProgress = currentProgress,
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