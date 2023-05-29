package com.example.demo.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeriesViewModel : ViewModel() {
    var data = MutableLiveData<SeriesDetails>()

    init {
        data.value = SeriesDetails("The Vampire Diaries", "Paul", "10")
    }
}