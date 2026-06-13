package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ai_recipe_app_kotlin.data.SimpleData

@Composable
fun IngredientList() {
    LazyRow(

    ) {
        items(SimpleData.ingredients) { item ->
            IngredientCard(item = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientListPreview() {
    IngredientList()
}