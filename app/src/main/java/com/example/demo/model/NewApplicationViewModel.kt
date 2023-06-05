package com.example.demo.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewApplicationViewModel: ViewModel() {
    private val userData = MutableLiveData<NewApplicationModel>()
    val data: LiveData<NewApplicationModel> = userData

    fun updateDestination(destination: String) {
        userData.value?.destination = destination
    }
}