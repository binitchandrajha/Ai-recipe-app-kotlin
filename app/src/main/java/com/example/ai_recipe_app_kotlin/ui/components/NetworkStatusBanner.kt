package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_recipe_app_kotlin.utils.ConnectivityObserver

@Composable
fun NetworkStatusBanner(status: ConnectivityObserver.Status) {
    val backgroundColor = when (status) {
        ConnectivityObserver.Status.Available -> Color(0xFF4CAF50) // Green
        else -> Color(0xFFF44336) // Red
    }

    val message = when (status) {
        ConnectivityObserver.Status.Available -> "Back Online"
        ConnectivityObserver.Status.Unavailable -> "You are offline"
        ConnectivityObserver.Status.Losing -> "Losing Connection..."
        ConnectivityObserver.Status.Lost -> "You are offline"
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
