package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai_recipe_app_kotlin.data.SimpleData
import com.example.ai_recipe_app_kotlin.ui.components.ListEmptyContent
import com.example.ai_recipe_app_kotlin.ui.components.SavedRecipeCardItem
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor



@Composable
fun SavedScreen(){
    Scaffold(
        containerColor = PrimaryColor,
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxWidth().padding(innerPadding)
        ){
            Text(
                text = "Saved Recipes",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(20.dp))

            if(SimpleData.savedRecipes.isEmpty()){
               ListEmptyContent()
            } else {
                LazyColumn() {
                    items(SimpleData.savedRecipes) { item ->
                        SavedRecipeCardItem(item = item)
                        Spacer(modifier = Modifier.size(10.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SavedScreenPreview(){
    SavedScreen()
}