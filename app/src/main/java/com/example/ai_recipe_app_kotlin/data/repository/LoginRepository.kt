package com.example.ai_recipe_app_kotlin.data.repository

import com.example.ai_recipe_app_kotlin.data.SessionManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(private val sessionManager: SessionManager) {
    fun saveLoginSession(){
        return sessionManager.setUserLoggedIn()
    }
    fun clearLoginSession(){
        return sessionManager.clearLoginSession()
    }
    fun checkLoginStatus() : Boolean{
        return sessionManager.isUserLoggedIn()
    }
}