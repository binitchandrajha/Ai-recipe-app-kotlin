package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.data.SimpleData

@Composable
fun QuickIdeasRecipeList(
    onRecipeClick: (String) -> Unit = {}
){
    fun handleOnRecipeClick(recipeId: String){
        onRecipeClick(recipeId)
    }
    Column(
        modifier = Modifier.padding(16.dp)
    ){
        Text(
            text = "Quick Ideas",
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.size(10.dp))
        LazyRow() {
            items(SimpleData.quickIdeas){ item ->
              QuickIdeasRecipeListItem(item = item,
                  onRecipeClick = {
                  handleOnRecipeClick(recipeId = it)
              })
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuickIdeasRecipeListPreview(){
    QuickIdeasRecipeList()
}