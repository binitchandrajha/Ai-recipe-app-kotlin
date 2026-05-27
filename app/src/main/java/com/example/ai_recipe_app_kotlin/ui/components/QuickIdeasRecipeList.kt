package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun QuickIdeasRecipeList(){
    Column(
        modifier = Modifier.padding(16.dp)
    ){
        Text(
            text = "Quick Ideas",
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.size(10.dp))
        QuickIdeasRecipeListItem()
    }
}

@Preview(showBackground = true)
@Composable
fun QuickIdeasRecipeListPreview(){
    QuickIdeasRecipeList()
}