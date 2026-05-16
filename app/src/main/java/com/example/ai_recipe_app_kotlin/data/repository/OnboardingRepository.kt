package com.example.ai_recipe_app_kotlin.data.repository

import com.example.ai_recipe_app_kotlin.data.SessionManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OnboardingRepository @Inject constructor(private val sessionManager: SessionManager) {
    fun checkOnboardingStatus(): Boolean{
       return sessionManager.isOnboardingCompleted()
    }

    fun saveOnboardingFinished(){
        sessionManager.setOnboardingCompleted()
    }
}