package com.example.ai_recipe_app_kotlin.utils

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class ToastType {
    SUCCESS,
    ERROR,
}

data class ToastState(
    val message: String,
    val type: ToastType,
    val id: Long = System.currentTimeMillis() // unique id for re-triggering
)

object ToastManager {
    private val _toast = MutableStateFlow<ToastState?>(null)
    val toast: StateFlow<ToastState?> = _toast.asStateFlow()

    fun showSuccess(message: String){
        _toast.value = ToastState(message, ToastType.SUCCESS)
    }

    fun showError(message: String){
        _toast.value = ToastState(message, ToastType.ERROR)
    }

    fun dismiss(){
        _toast.value = null
    }
}