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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ai_recipe_app_kotlin.data.SimpleData
import com.example.ai_recipe_app_kotlin.model.network.RecipeItem
import com.example.ai_recipe_app_kotlin.ui.components.ListEmptyContent
import com.example.ai_recipe_app_kotlin.ui.components.OverlayLoader
import com.example.ai_recipe_app_kotlin.ui.components.SavedRecipeCardItem
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor
import com.example.ai_recipe_app_kotlin.utils.ToastManager
import com.example.ai_recipe_app_kotlin.viewmodel.RecipeViewModel


@Composable
fun SavedScreen(
    recipeViewModel: RecipeViewModel = hiltViewModel()
){
    var savedRecipes by remember { mutableStateOf<List<RecipeItem>>(emptyList()) }
    val isGettingSavedRecipes by recipeViewModel.isGettingSavedRecipes.collectAsState()

    LaunchedEffect(Unit) {
        recipeViewModel.getSavedRecipes({
                recipes ->
            savedRecipes = recipes ?: emptyList()
        }, {
                errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }
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

            if(savedRecipes.isEmpty()){
               ListEmptyContent()
            } else {
                LazyColumn() {
                    items(savedRecipes) { item ->
                        SavedRecipeCardItem(item = item)
                        Spacer(modifier = Modifier.size(10.dp))
                    }
                }
            }

            OverlayLoader(
                isLoading = isGettingSavedRecipes
            )
        }
    }
}

@Preview
@Composable
fun SavedScreenPreview(){
    SavedScreen()
}