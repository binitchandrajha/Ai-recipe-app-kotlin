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
import com.example.ai_recipe_app_kotlin.model.network.GenerateRecipeRequest
import com.example.ai_recipe_app_kotlin.model.network.IngredientData
import com.example.ai_recipe_app_kotlin.model.network.RecipeItem
import com.example.ai_recipe_app_kotlin.model.network.UserData
import com.example.ai_recipe_app_kotlin.ui.components.ConfirmationPopupModal
import com.example.ai_recipe_app_kotlin.ui.components.GenerateRecipeProgressModal
import com.example.ai_recipe_app_kotlin.ui.components.HomeContent
import com.example.ai_recipe_app_kotlin.utils.ToastManager
import com.example.ai_recipe_app_kotlin.viewmodel.IngredientViewModel
import com.example.ai_recipe_app_kotlin.viewmodel.ProfileViewModel
import com.example.ai_recipe_app_kotlin.viewmodel.RecipeViewModel
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    onRecipeClick: (String) -> Unit = {},
    onRecipesGenerated: (List<RecipeItem>) -> Unit = {},
    profileViewModel: ProfileViewModel = hiltViewModel(),
    ingredientViewModel: IngredientViewModel = hiltViewModel(),
    recipeViewModel: RecipeViewModel = hiltViewModel()
){
    var userInfo by remember {mutableStateOf<UserData?>(null)}
    val isFetchingProfileInfo by profileViewModel.isFetchingProfileInfo.collectAsState()
    val isGettingRecipeQuickIdeas by recipeViewModel.isGettingRecipeQuickIdeas.collectAsState()
    var searchInput by remember { mutableStateOf("") }
    var ingredientList by remember { mutableStateOf<List<IngredientData>?>(null) }
    var selectedIngredientList by remember { mutableStateOf(emptyList<IngredientData>()) }
    var isGenerating by remember { mutableStateOf(false) }
    var generatedRecipes by remember { mutableStateOf<List<RecipeItem>>(emptyList()) }
    var quickIdeas by remember { mutableStateOf<List<RecipeItem>>(emptyList()) }
    var savedRecipes by remember { mutableStateOf<List<RecipeItem>>(emptyList<RecipeItem>()) }
    var showModal by remember { mutableStateOf(false) }
    val isMarkingRecipeFavorite by recipeViewModel.isMarkingRecipeFavorite.collectAsState()
    val isRemoveRecipeFavorite by recipeViewModel.isRemoveRecipeFavorite.collectAsState()
    var showConfirmationModal by remember { mutableStateOf(false) }
    var selectedRecipeID by remember { mutableStateOf<String>("") }

    LaunchedEffect(Unit) {
        profileViewModel.getUserProfile({
                profileInfo ->
            userInfo = profileInfo
        }, {
                errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }

    LaunchedEffect(Unit) {
        recipeViewModel.getSavedRecipes({
                recipes ->
            savedRecipes = recipes ?: emptyList()
        },{
                errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }

    fun handleSelectedIngredient(ingredient: IngredientData){
        println("selected ingredient: ${ingredient.title}")
       val isAlreadySelected = selectedIngredientList.any { it.id == ingredient.id }

        if(isAlreadySelected){
            selectedIngredientList = selectedIngredientList.filter { it.id != ingredient.id }
        }else{
            selectedIngredientList = selectedIngredientList + ingredient
        }
    }

    fun onGenerateRecipeClick(){
        if(selectedIngredientList.isEmpty()){
            ToastManager.showError("Please select at least one ingredient")
        } else {
            val ingredientsTitle = selectedIngredientList.map { it.title }
            val request = GenerateRecipeRequest(
                ingredients = ingredientsTitle
            )
            showModal = true
            isGenerating = true
            recipeViewModel.generateRecipes(request, {
                    recipes ->
                generatedRecipes = recipes ?: emptyList()
                isGenerating = false
            },{ errorMessage ->
                ToastManager.showError(errorMessage)
                showModal = false
                isGenerating = false
            })
        }
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

    LaunchedEffect(Unit) {
        recipeViewModel.getRecipesQuickIdeas({
                recipes ->
            quickIdeas = recipes ?: emptyList()
        }, {
                errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }

    fun handleUpdateListRecipes(updatedRecipe: RecipeItem){
       quickIdeas = quickIdeas.map {
          if(it.id == updatedRecipe.id) updatedRecipe else it
       }

        val isAlreadySaved = savedRecipes.any { it.id == updatedRecipe.id }

        if(!isAlreadySaved){
            savedRecipes = savedRecipes + updatedRecipe
        } else {
            savedRecipes = savedRecipes.filter { savedRecipes -> savedRecipes.id != updatedRecipe.id }
        }


    }

    fun handleMarkSaveRecipe(recipeID: String){
        recipeViewModel.markRecipeFavorite(recipeID, { successMessage, recipe ->
            recipe?.let {
                handleUpdateListRecipes(it)
                ToastManager.showSuccess(successMessage)
            }
        }, { errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }

    fun handleRemoveFavorite(recipeID: String){
        recipeViewModel.removeRecipeFavorite(recipeID, { successMessage,
                recipe ->
            recipe?.let {
                handleUpdateListRecipes(it)
                ToastManager.showSuccess(successMessage)
            }
        }, {
            errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }



    HomeContent(
        onRecipeClick = onRecipeClick,
        userInfo = userInfo,
        isLoading = isFetchingProfileInfo || isMarkingRecipeFavorite || isRemoveRecipeFavorite,
        isGettingRecipeQuickIdeas = isGettingRecipeQuickIdeas,
        ingredientList = ingredientList,
        searchInput = searchInput,
        onChangeSearchInput = { input ->
            onChangeSearchInput(input)
        },
        selectedIngredientList = selectedIngredientList,
        handleSelectedIngredient= { item: IngredientData ->
            handleSelectedIngredient(item)
        },
        onGenerateRecipeClick = {
            onGenerateRecipeClick()
        },
        markSaveRecipe = { recipeID: String ->
            handleMarkSaveRecipe(recipeID)
        },
        removeFavorite = { recipeID: String ->
            selectedRecipeID = recipeID
            showConfirmationModal = true
        },
        quickIdeas = quickIdeas,
        savedRecipes = savedRecipes
    )

    GenerateRecipeProgressModal(
        showModal = showModal,
        isLoading = isGenerating,
        onFinished = {
            showModal = false
            onRecipesGenerated(generatedRecipes)
        },
        onDismiss = {
            showModal = false
        }
    )

    ConfirmationPopupModal(
        showModal = showConfirmationModal,
        onDismiss = {
            showConfirmationModal = false
            selectedRecipeID = ""
        },
        onConfirm = {
            handleRemoveFavorite(selectedRecipeID)
            showConfirmationModal = false
        },
        confirmationText = "Are you sure want to remove this recipe from your saved recipes?"
    )
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}