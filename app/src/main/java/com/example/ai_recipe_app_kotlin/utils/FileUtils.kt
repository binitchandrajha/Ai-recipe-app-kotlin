package com.example.ai_recipe_app_kotlin.utils

import android.content.Context
import android.net.Uri
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody

object FileUtils {
    /**
     * @param context
     * @param uri
     * @param paramName
     */
    fun getMultipartImage(context: Context, uri: Uri, paramName: String): MultipartBody.Part? {
        return try {
            val inputStream = context.contentResolver.openInputStream(uri)
            val bytes = inputStream?.use { it.readBytes() }

            bytes?.let {
                val requestFile = it.toRequestBody("image/jpeg".toMediaTypeOrNull())

                MultipartBody.Part.createFormData(paramName, "profile_avatar.jpg", requestFile)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun formatImageUrl(url: String?) : String? {
        if(url?.isEmpty() == true) return  null
        return url?.replace("localhost", "10.0.2.2")
    }
}