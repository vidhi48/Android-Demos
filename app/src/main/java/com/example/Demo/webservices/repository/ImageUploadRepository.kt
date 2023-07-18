package com.example.demo.webservices.repository

import androidx.lifecycle.MutableLiveData
import com.example.demo.webservices.interfaces.UserService
import okhttp3.MultipartBody

class ImageUploadRepository(private val uploadImageService: UserService) {

    private val _imageResponse = MutableLiveData<Boolean?>()
    val imageResponse = _imageResponse

    suspend fun uploadImage(part: MultipartBody.Part) {
        val response = uploadImageService.uploadImage("eb2fd383fa5155917cee090c0367c01b", part)
        _imageResponse.postValue(response.success)
    }
}