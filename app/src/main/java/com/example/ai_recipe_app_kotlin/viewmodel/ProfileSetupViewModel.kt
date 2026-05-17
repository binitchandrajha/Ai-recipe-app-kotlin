package com.example.ai_recipe_app_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ai_recipe_app_kotlin.data.repository.ProfileSetupRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileSetupViewModel @Inject constructor(private val profileSetupRepository: ProfileSetupRepository) : ViewModel(){
    private val _isProfileSetupDone = MutableStateFlow<Boolean>(false)
    val isProfileSetupDone = _isProfileSetupDone.asStateFlow()

    init {
        getInitialProfileSetupStatus()
    }

    private fun getInitialProfileSetupStatus(){
        viewModelScope.launch {
            _isProfileSetupDone.value = profileSetupRepository.getInitialProfileSetupStatus()
        }
    }

    fun setInitialProfileSetup(){
        viewModelScope.launch {
            profileSetupRepository.setInitialProfileSetup()
            _isProfileSetupDone.value = true
        }
    }

    fun clearInitialProfileSetup(){
        viewModelScope.launch {
            profileSetupRepository.clearInitialProfileSetup()
            _isProfileSetupDone.value = false
        }
    }
}