package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ai_recipe_app_kotlin.model.network.IngredientData
import com.example.ai_recipe_app_kotlin.model.network.UserData
import com.example.ai_recipe_app_kotlin.ui.components.HomeContent
import com.example.ai_recipe_app_kotlin.utils.ToastManager
import com.example.ai_recipe_app_kotlin.viewmodel.IngredientViewModel
import com.example.ai_recipe_app_kotlin.viewmodel.ProfileViewModel
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    onRecipeClick: (String) -> Unit = {},
    profileViewModel: ProfileViewModel = hiltViewModel(),
    ingredientViewModel: IngredientViewModel = hiltViewModel()
){
    var userInfo by remember {mutableStateOf<UserData?>(null)}
    val isFetchingProfileInfo by profileViewModel.isFetchingProfileInfo.collectAsState()
    val isFetchingIngredients by ingredientViewModel.isFetchingIngredients.collectAsState()
    var searchInput by remember { mutableStateOf("") }
    var ingredientList by remember { mutableStateOf<List<IngredientData>?>(null) }

    LaunchedEffect(Unit) {
        profileViewModel.getUserProfile({
                profileInfo ->
            userInfo = profileInfo
        }, {
                errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }

    suspend fun searchIngredients(query: String){
        ingredientViewModel.fetchIngredients(query, {
                data ->
               ingredientList = data
        }, {
                errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }

    fun onChangeSearchInput(input: String){
        searchInput = input
    }

    LaunchedEffect(searchInput) {
        delay(800L)
        searchIngredients(searchInput)
    }

    HomeContent(
        onRecipeClick = onRecipeClick,
        userInfo = userInfo,
        isLoading = isFetchingProfileInfo,
        isFetchingIngredients = isFetchingIngredients,
        ingredientList = ingredientList,
        searchInput = searchInput,
        onChangeSearchInput = { input ->
            onChangeSearchInput(input)
        }
    )
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}