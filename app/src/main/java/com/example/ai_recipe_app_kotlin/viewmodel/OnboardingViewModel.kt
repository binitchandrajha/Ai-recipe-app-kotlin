package com.example.ai_recipe_app_kotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ai_recipe_app_kotlin.data.repository.OnboardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val onboardingRepository: OnboardingRepository): ViewModel() {
    private val _isOnboardingCompleted = MutableStateFlow<Boolean>(false)
    val isOnboardingCompleted = _isOnboardingCompleted.asStateFlow()

    init {
        loadOnboardingStatus()
    }

    private fun loadOnboardingStatus(){
        viewModelScope.launch {
          _isOnboardingCompleted.value = onboardingRepository.checkOnboardingStatus()
        }
    }

    fun saveOnboardingFinished(){
        viewModelScope.launch {
            onboardingRepository.saveOnboardingFinished()
            _isOnboardingCompleted.value = true
        }
    }
}