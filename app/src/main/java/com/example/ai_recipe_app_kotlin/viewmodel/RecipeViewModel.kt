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
    val isGeneratingRecipes = _isGeneratingRecipes.asStateFlow()

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
            }.onFailure {
                _isGeneratingRecipes.value = false
                val errMessage = NetworkUtils.parseError(it)
                onFailure(errMessage)
            }
        }
    }
}