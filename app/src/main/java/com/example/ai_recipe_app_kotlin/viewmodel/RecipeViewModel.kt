package com.example.ai_recipe_app_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ai_recipe_app_kotlin.data.repository.RecipeRepository
import com.example.ai_recipe_app_kotlin.model.network.GenerateRecipeRequest
import com.example.ai_recipe_app_kotlin.model.network.RecipeItem
import com.example.ai_recipe_app_kotlin.utils.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    private val _isGeneratingRecipes = MutableStateFlow<Boolean>(false)
    private val _isGettingRecipeDetail = MutableStateFlow<Boolean>(false)
    private val _isGettingRecipeQuickIdeas = MutableStateFlow<Boolean>(false)

    private val _isGettingSavedRecipes = MutableStateFlow<Boolean>(false)

    private val _isMarkingRecipeFavorite = MutableStateFlow<Boolean>(false)
    private val _isRemoveRecipeFavorite = MutableStateFlow<Boolean>(false)

    val isGeneratingRecipes = _isGeneratingRecipes.asStateFlow()
    val isGettingRecipeDetail = _isGettingRecipeDetail.asStateFlow()
    val isGettingRecipeQuickIdeas = _isGettingRecipeQuickIdeas.asStateFlow()
    val isGettingSavedRecipes = _isGettingSavedRecipes.asStateFlow()
    val isMarkingRecipeFavorite = _isMarkingRecipeFavorite.asStateFlow()
    val isRemoveRecipeFavorite = _isRemoveRecipeFavorite.asStateFlow()


    fun generateRecipes(
        request: GenerateRecipeRequest,
        onSuccess: (List<RecipeItem>?) -> Unit,
        onFailure: (errorMessage: String) -> Unit
    ) {
        viewModelScope.launch {
            _isGeneratingRecipes.value = true
            val result = recipeRepository.generateRecipe(request)
            result.onSuccess { response ->
                _isGeneratingRecipes.value = false
                onSuccess(response.data)
            }.onFailure { exception ->
                _isGeneratingRecipes.value = false
                val errMessage = NetworkUtils.parseError(exception)
                onFailure(errMessage)
            }
        }
    }

    fun getRecipeDetailById(id: String,onSuccess: (RecipeItem?) -> Unit, onFailure: (errorMessage: String) -> Unit){
        viewModelScope.launch {
            _isGettingRecipeDetail.value = true
            val result = recipeRepository.getRecipeDetail(id)
            result.onSuccess{ response ->
                _isGettingRecipeDetail.value = false
                onSuccess(response.data)
            }.onFailure { exception ->
                _isGettingRecipeDetail.value = false
                val errMessage = NetworkUtils.parseError(exception)
                onFailure(errMessage)
            }
        }
    }

    fun getRecipesQuickIdeas(onSuccess: (List<RecipeItem>?) -> Unit, onFailure: (errorMessage: String) -> Unit){
        viewModelScope.launch {
            _isGettingRecipeQuickIdeas.value = true
            val result = recipeRepository.getRecipesQuickIdeas()
            result.onSuccess { response ->
             _isGettingRecipeQuickIdeas.value = false
                onSuccess(response.data)
            }.onFailure { exception ->
                _isGettingRecipeQuickIdeas.value = false
                val errorMessage = NetworkUtils.parseError(exception)
                onFailure(errorMessage)
            }
        }
    }

    fun getSavedRecipes(onSuccess: (List<RecipeItem>?) -> Unit, onFailure: (errorMessage: String) -> Unit){
        viewModelScope.launch {
            _isGettingSavedRecipes.value = true
            val result = recipeRepository.getSavedRecipes()
            result.onSuccess { response ->
               _isGettingSavedRecipes.value = false
                onSuccess(response.data)
            }.onFailure { exception ->
                _isGettingSavedRecipes.value = false
                val errorMessage = NetworkUtils.parseError(exception)
                onFailure(errorMessage)
            }
        }
    }

    fun markRecipeFavorite(id: String, onSuccess: (successMessage: String,RecipeItem?) -> Unit, onFailure: (errorMessage: String) -> Unit){
        viewModelScope.launch {
           _isMarkingRecipeFavorite.value = true
            val result = recipeRepository.markRecipeFavorite(id)
            result.onSuccess { response ->
                _isMarkingRecipeFavorite.value = false
                onSuccess(response.message,response.data)
            }.onFailure { exception ->
                _isMarkingRecipeFavorite.value = false
                val errorMessage = NetworkUtils.parseError(exception)
                onFailure(errorMessage)
            }
        }
    }

    fun removeRecipeFavorite(id: String, onSuccess: (successMessage: String,RecipeItem?) -> Unit, onFailure: (errorMessage: String) -> Unit){
        viewModelScope.launch {
            _isRemoveRecipeFavorite.value = true
            val result = recipeRepository.removeRecipeFavorite(id)
            result.onSuccess { response ->
                _isRemoveRecipeFavorite.value = false
                onSuccess(response.message,response.data)
            }.onFailure { exception ->
                _isRemoveRecipeFavorite.value = false
                val errorMessage = NetworkUtils.parseError(exception)
                onFailure(errorMessage)
            }
        }
    }
}