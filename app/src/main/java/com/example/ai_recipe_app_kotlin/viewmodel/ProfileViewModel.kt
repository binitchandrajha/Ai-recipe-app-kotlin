package com.example.ai_recipe_app_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ai_recipe_app_kotlin.data.repository.ProfileRepository
import com.example.ai_recipe_app_kotlin.model.network.ProfileUpdateRequest
import com.example.ai_recipe_app_kotlin.utils.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {
    private val _isUpdatingProfile = MutableStateFlow<Boolean>(false)
    val isUpdatingProfile = _isUpdatingProfile.asStateFlow()

     fun updateProfile(request: ProfileUpdateRequest, onSuccess: (successMessage: String) -> Unit, onFailure: (errorMessage: String) -> Unit){
       viewModelScope.launch {
           _isUpdatingProfile.value = true
           val result = profileRepository.updateProfile(request)
           result.onSuccess { response ->
               _isUpdatingProfile.value = false
               onSuccess(response.message)
           }.onFailure {
               _isUpdatingProfile.value = false
               val errMessage = NetworkUtils.parseError(it)
               onFailure(errMessage)
           }
       }
    }
}