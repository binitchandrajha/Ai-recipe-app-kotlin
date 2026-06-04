package com.example.ai_recipe_app_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ai_recipe_app_kotlin.data.repository.AuthRepository
import com.example.ai_recipe_app_kotlin.data.repository.LoginRepository
import com.example.ai_recipe_app_kotlin.model.network.SendOtpRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _isLoggedIn = MutableStateFlow<Boolean>(false)
    private val _isSendingOtp = MutableStateFlow<Boolean>(false)
    val isLoggedIn = _isLoggedIn.asStateFlow()
    val isSendingOtp = _isSendingOtp.asStateFlow()

    init {
        checkLoginStatus()
    }

    private fun checkLoginStatus() {
        viewModelScope.launch {
            _isLoggedIn.value = loginRepository.checkLoginStatus()
        }
    }

    fun saveLoginSession() {
        viewModelScope.launch {
            loginRepository.saveLoginSession()
            _isLoggedIn.value = true
        }
    }

    fun onSendOtpClick(payload: SendOtpRequest){
        viewModelScope.launch {
            _isSendingOtp.value = true
            val result = authRepository.sendOtp(payload)
            result.onSuccess {
                _isSendingOtp.value = false
            }.onFailure {
                _isSendingOtp.value = false
            }
        }
    }
}