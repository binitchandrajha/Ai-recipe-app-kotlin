package com.example.ai_recipe_app_kotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ai_recipe_app_kotlin.data.repository.OnboardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val onboardingRepository: OnboardingRepository): ViewModel() {
    private val _isOnboardingCompleted = MutableLiveData<Boolean>()
    val isOnboardingCompleted: LiveData<Boolean> = _isOnboardingCompleted

    init {
        _isOnboardingCompleted.value = onboardingRepository.checkOnboardingStatus()
    }

    fun saveOnboardingFinished(){
        onboardingRepository.saveOnboardingFinished()
        _isOnboardingCompleted.value = true
    }
}