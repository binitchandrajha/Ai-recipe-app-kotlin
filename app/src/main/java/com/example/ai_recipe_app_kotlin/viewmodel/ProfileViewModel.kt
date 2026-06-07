package com.example.ai_recipe_app_kotlin.viewmodel

import com.example.ai_recipe_app_kotlin.model.network.UserData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ai_recipe_app_kotlin.data.repository.ProfileRepository
import com.example.ai_recipe_app_kotlin.model.network.ProfileUpdateRequest
import com.example.ai_recipe_app_kotlin.utils.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {
    private val _isUpdatingProfile = MutableStateFlow<Boolean>(false)
    private val _isFetchingProfileInfo = MutableStateFlow<Boolean>(true)
    private val _isProfilePicUpdating = MutableStateFlow<Boolean>(false)

    val isUpdatingProfile = _isUpdatingProfile.asStateFlow()
    val isFetchingProfileInfo = _isFetchingProfileInfo.asStateFlow()
    val isProfilePicUpdating = _isProfilePicUpdating.asStateFlow()

     fun updateProfile(request: ProfileUpdateRequest, onSuccess: (successMessage: String) -> Unit, onFailure: (errorMessage: String) -> Unit){
       viewModelScope.launch {
           _isUpdatingProfile.value = true
           val result = profileRepository.updateProfile(request)
           result.onSuccess { response ->
               _isUpdatingProfile.value = false
               onSuccess(response.message)
           }.onFailure {
               _isUpdatingProfile.value = false
               val errMessage = NetworkUtils.parseError(it)
               onFailure(errMessage)
           }
       }
    }

    fun getUserProfile(onSuccess: (profileInfo: UserData?) -> Unit, onFailure: (errorMessage: String) -> Unit) {
        viewModelScope.launch {
            _isFetchingProfileInfo.value = true
            val result = profileRepository.getProfile()
            result.onSuccess { response ->
                _isFetchingProfileInfo.value = false
                onSuccess(response.data)
            }.onFailure {
                _isFetchingProfileInfo.value = false
                val errMessage = NetworkUtils.parseError(it)
                onFailure(errMessage)
            }
        }
    }

    fun updateProfilePic(image: MultipartBody.Part, onSuccess: (successMessage: String) -> Unit, onFailure: (errorMessage: String) -> Unit) {
        viewModelScope.launch {
            _isProfilePicUpdating.value = true
            val result = profileRepository.updateProfilePic(image)
            result.onSuccess { response ->
                _isProfilePicUpdating.value = false
                onSuccess(response.message)
            }.onFailure { exception ->
                _isProfilePicUpdating.value = false
                val errMessage = NetworkUtils.parseError(exception)
                onFailure(errMessage)
            }
        }
    }
}