package com.example.demo.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResortApplication: ViewModel() {
    var userData = MutableLiveData<String>()
    val getUserInput: LiveData<String> = userData

//    init {
//        Thread {
//            while (true) {
//                Thread.sleep(2000)
//                Log.d("abcd", userData.value.toString())
//            }
//        }.start()
//    }
}