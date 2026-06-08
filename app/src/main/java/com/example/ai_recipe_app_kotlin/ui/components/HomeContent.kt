package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ai_recipe_app_kotlin.model.network.UserData
import com.example.ai_recipe_app_kotlin.ui.theme.PrimaryColor

@Composable
fun HomeContent(
    onRecipeClick: (String) -> Unit = {},
    userInfo: UserData? = null,
    isLoading: Boolean = false
){
    val scrollState = rememberScrollState()
    Scaffold(
        containerColor = PrimaryColor
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).verticalScroll(scrollState)
        ){
            ProfileHeader(
                userInfo = userInfo
            )
            IngredientSearchCard(
                onRecipeClick = onRecipeClick
            )
            SavedRecipeCard(
                onRecipeClick = onRecipeClick
            )
            QuickIdeasRecipeList(
                onRecipeClick = onRecipeClick
            )

            OverlayLoader(
                isLoading = isLoading
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview(){
    HomeContent()
}