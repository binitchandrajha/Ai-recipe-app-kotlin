package com.example.ai_recipe_app_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ai_recipe_app_kotlin.data.repository.IngredientRepository
import com.example.ai_recipe_app_kotlin.model.network.IngredientData
import com.example.ai_recipe_app_kotlin.utils.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IngredientViewModel @Inject constructor(
    private val ingredientRepository: IngredientRepository
) : ViewModel() {
   private val _isFetchingIngredients = MutableStateFlow<Boolean>(false)
    val isFetchingIngredients = _isFetchingIngredients.asStateFlow()

    suspend fun fetchIngredients(query: String? = null, onSuccess: (data: List<IngredientData>?) -> Unit, onFailure: (errorMessage: String) -> Unit){
        viewModelScope.launch {
            _isFetchingIngredients.value = true
            val result = ingredientRepository.fetchIngredients(query)
            result.onSuccess { response ->
                _isFetchingIngredients.value = false
                onSuccess(response.data)
            }.onFailure { exception ->
                _isFetchingIngredients.value = false
                val errMessage = NetworkUtils.parseError(exception)
                onFailure(errMessage)
            }
        }
    }
}