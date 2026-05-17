package com.example.ai_recipe_app_kotlin.data.repository

import com.example.ai_recipe_app_kotlin.data.SessionManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileSetupRepository @Inject constructor(private val sessionManager: SessionManager) {
    fun getInitialProfileSetupStatus() : Boolean{
        return  sessionManager.isInitialProfileSetupDone()
    }

    fun setInitialProfileSetup(){
        sessionManager.setInitialProfileSetup()
    }

    fun clearInitialProfileSetup(){
        sessionManager.clearInitialProfileSetup()
    }
}