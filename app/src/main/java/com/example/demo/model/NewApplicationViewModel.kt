package com.example.demo.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Date

class NewApplicationViewModel: ViewModel() {
    val destination = MutableLiveData<String>("")
    val date = MutableLiveData<String>("")
    val nights = MutableLiveData<String>("")
    val guests = MutableLiveData<String>("")
    val bedrooms = MutableLiveData<String>("")
    val type = MutableLiveData<String>("")
}