package com.example.demo.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val data = MutableLiveData<String>()

    fun sendData(text: String) {
        data.value = text
    }
}