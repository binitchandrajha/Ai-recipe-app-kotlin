package com.example.ai_recipe_app_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ai_recipe_app_kotlin.data.repository.AuthRepository
import com.example.ai_recipe_app_kotlin.data.repository.LoginRepository
import com.example.ai_recipe_app_kotlin.data.repository.ProfileSetupRepository
import com.example.ai_recipe_app_kotlin.model.network.SendOtpRequest
import com.example.ai_recipe_app_kotlin.model.network.VerifyOtpRequest
import com.example.ai_recipe_app_kotlin.utils.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val authRepository: AuthRepository,
    private val profileSetupRepository: ProfileSetupRepository
) : ViewModel() {
    private val _isLoggedIn = MutableStateFlow<Boolean>(false)
    private val _isSendingOtp = MutableStateFlow<Boolean>(false)
    private val _isVerifyingOtp = MutableStateFlow<Boolean>(false)
    val isLoggedIn = _isLoggedIn.asStateFlow()
    val isSendingOtp = _isSendingOtp.asStateFlow()
    val isVerifyingOtp = _isVerifyingOtp.asStateFlow()

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
    fun onSendOtpClick(payload: SendOtpRequest, onSuccess: (successMessage: String) -> Unit, onFailure: (errorMessage: String) -> Unit){
        viewModelScope.launch {
            _isSendingOtp.value = true
            val result = authRepository.sendOtp(payload)
            result.onSuccess { response ->
                _isSendingOtp.value = false
                onSuccess(response.message)
            }.onFailure { exception ->
                _isSendingOtp.value = false
                val errMessage = NetworkUtils.parseError(exception)
                onFailure(errMessage)
            }
        }
    }

    fun onVerifyOtpClick(payload: VerifyOtpRequest, onSuccess: (successMessage: String) -> Unit, onFailure: (errorMessage: String) -> Unit){
        viewModelScope.launch {
            _isVerifyingOtp.value = true
            val result = authRepository.verifyOtp(payload)
            result.onSuccess { response ->
                _isVerifyingOtp.value = false
                onSuccess(response.message)
            }.onFailure {
                _isVerifyingOtp.value = false
                val errMessage = NetworkUtils.parseError(it)
                onFailure(errMessage)
            }
        }
    }

    fun logout(onSuccess: (successMessage: String) -> Unit, onFailure: (errorMessage: String) -> Unit){
        viewModelScope.launch {
            try {
                loginRepository.clearLoginSession()
                authRepository.clearAuthToken()
                profileSetupRepository.clearInitialProfileSetup()
                _isLoggedIn.value = false
                onSuccess("Logged out successfully")
            } catch (e: Exception){
                println("Error logging out: ${e.message}")
                onFailure("Failed to logout")
            }
        }
    }
}