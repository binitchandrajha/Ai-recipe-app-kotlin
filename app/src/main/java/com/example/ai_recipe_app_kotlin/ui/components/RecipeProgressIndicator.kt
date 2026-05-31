package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun RecipeProgressIndicator(
    currentProgress: Float,
){
    LinearProgressIndicator(
        progress = { currentProgress },
       modifier = Modifier.fillMaxWidth().height(10.dp) ,
        color = DarkPrimaryColor,
        trackColor = DarkPrimaryColor.copy(alpha = 0.1f),
        strokeCap = StrokeCap.Round,
        gapSize = 0.dp,
    )
}

@Preview(showBackground = true)
@Composable
fun RecipeProgressIndicatorPreview(){
    RecipeProgressIndicator(
        currentProgress = 0.5f
    )
}