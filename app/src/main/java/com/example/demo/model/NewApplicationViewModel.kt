package com.example.demo.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewApplicationViewModel: ViewModel() {
    val userData = MutableLiveData<String>("")
}