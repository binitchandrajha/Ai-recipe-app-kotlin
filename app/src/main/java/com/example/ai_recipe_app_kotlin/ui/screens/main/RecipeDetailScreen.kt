package com.example.ai_recipe_app_kotlin.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ai_recipe_app_kotlin.model.network.RecipeItem
import com.example.ai_recipe_app_kotlin.ui.components.AppAsyncImage
import com.example.ai_recipe_app_kotlin.ui.components.AppHeader
import com.example.ai_recipe_app_kotlin.ui.components.ConfirmationPopupModal
import com.example.ai_recipe_app_kotlin.ui.components.RecipeDetailContent
import com.example.ai_recipe_app_kotlin.ui.theme.LightPrimaryColor
import com.example.ai_recipe_app_kotlin.ui.theme.SoftWhite
import com.example.ai_recipe_app_kotlin.utils.ToastManager
import com.example.ai_recipe_app_kotlin.viewmodel.RecipeViewModel


@Composable
fun RecipeDetailScreen(
    navController: NavController,
    recipeId: String,
    viewModel: RecipeViewModel = hiltViewModel()
){
    val isGettingRecipeDetail by viewModel.isGettingRecipeDetail.collectAsState()
    val isMarkingRecipeFavorite by viewModel.isMarkingRecipeFavorite.collectAsState()
    val isRemoveRecipeFavorite by viewModel.isRemoveRecipeFavorite.collectAsState()
    var recipeDetail by remember { mutableStateOf<RecipeItem?>(null) }
    var showConfirmationModal by remember { mutableStateOf(false) }

    LaunchedEffect(recipeId){
      viewModel.getRecipeDetailById(recipeId, {
          recipe ->
          recipeDetail = recipe
      }, { errorMessage ->
          ToastManager.showError(errorMessage)
      })
    }
    val scrollState = rememberScrollState()

    fun handleMarkSaveRecipe(){
        viewModel.markRecipeFavorite(recipeId, { successMessage, recipe ->
            recipe?.let {
                ToastManager.showSuccess(successMessage)
                recipeDetail = recipeDetail?.copy(isFavorite = true)
            }
        }, { errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }

    fun handleRemoveFavorite(){
        viewModel.removeRecipeFavorite(recipeId, { successMessage, recipe ->
            recipe?.let {
                ToastManager.showSuccess(successMessage)
                recipeDetail = recipeDetail?.copy(isFavorite = false)
            }
        }, {
                errorMessage ->
            ToastManager.showError(errorMessage)
        })
    }

    Scaffold(
        containerColor = SoftWhite,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier.clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)).background(LightPrimaryColor).height(400.dp).
                padding(top = innerPadding.calculateTopPadding())
            ) {
                AppHeader(
                    onBackClick = {
                        navController.popBackStack()
                    },
                    isFavoriteIconVisible = true,
                    isFavorite = recipeDetail?.isFavorite == true,
                    onSaveIconClick = {
                        if(recipeDetail?.isFavorite == true){
                            showConfirmationModal = true
                        } else {
                            handleMarkSaveRecipe()
                        }
                    }
                )
                AppAsyncImage(
                    model = recipeDetail?.recipeImage,
                    contentDescription = recipeDetail?.title,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight().weight(1f).padding(start = 32.dp, end = 32.dp, top = 16.dp),
                    contentScale = ContentScale.Crop,
                )
            }
            Column() {
                RecipeDetailContent(
                    recipe = recipeDetail,
                    onBackClick = {
                        navController.popBackStack()
                    },
                    isLoading = isGettingRecipeDetail || isMarkingRecipeFavorite || isRemoveRecipeFavorite,
                )
            }

            ConfirmationPopupModal(
                showModal = showConfirmationModal,
                onDismiss = {
                    showConfirmationModal = false
                },
                onConfirm = {
                    handleRemoveFavorite()
                    showConfirmationModal = false
                },
                confirmationText = "Are you sure want to remove this recipe from your saved recipes?"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailPreview(){
    RecipeDetailScreen(
        navController = NavController(LocalContext.current),
        recipeId = ""
    )
}