package com.example.demo.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataModel : ViewModel() {
    var text = MutableLiveData("Data binding using live data and view binding")
    fun updateText() {
        text.value = "text is updated."
    }
}