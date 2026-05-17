package com.example.ai_recipe_app_kotlin.data

import android.content.Context
import androidx.core.content.edit

class SessionManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun isOnboardingCompleted(): Boolean{
      return  sharedPreferences.getBoolean("onboarding_completed", false)
    }

    fun setOnboardingCompleted(){
        sharedPreferences.edit { putBoolean("onboarding_completed", true) }
    }

    fun isUserLoggedIn() : Boolean {
        return sharedPreferences.getBoolean("is_logged_in", false)
    }

    fun setUserLoggedIn(){
        sharedPreferences.edit { putBoolean("is_logged_in", true) }
    }

    fun clearLoginSession(){
        sharedPreferences.edit { putBoolean("is_logged_in", false) }
    }

}