package com.example.demo.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DemoViewModel: ViewModel() {
    val userData = MutableLiveData<DemoModel>(DemoModel())
    val data: LiveData<DemoModel> = userData
}