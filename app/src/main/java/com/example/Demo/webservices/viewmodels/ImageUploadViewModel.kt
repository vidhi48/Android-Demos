package com.example.demo.webservices.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.webservices.repository.ImageUploadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ImageUploadViewModel @Inject constructor(
    @Named("UploadImage")
    private val uploadImageRepository: ImageUploadRepository
) : ViewModel() {

    private val _imageResponse = MutableLiveData<Boolean>()
    val imageResponse: LiveData<Boolean> = _imageResponse

    fun uploadImage(file: File) {
        val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData("image", file.name, requestBody)
        viewModelScope.launch {
            uploadImageRepository.uploadImage(part)
            uploadImageRepository.imageResponse.observeForever {
                _imageResponse.value = it
            }
        }
    }
}