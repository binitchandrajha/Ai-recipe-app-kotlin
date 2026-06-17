package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ai_recipe_app_kotlin.model.network.RecipeItem
import com.example.ai_recipe_app_kotlin.ui.theme.DarkPrimaryColor

@Composable
fun QuickIdeasRecipeList(
    onRecipeClick: (String) -> Unit = {},
    isLoading: Boolean = false,
    quickIdeas: List<RecipeItem> = emptyList(),
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
        if(isLoading){
            CircularProgressIndicator(color = DarkPrimaryColor)
        }
        LazyRow() {
            items(quickIdeas){ item ->
              QuickIdeasRecipeListItem(
                  item = item,
                  onRecipeClick = { recipeId ->
                  handleOnRecipeClick(recipeId = recipeId)
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