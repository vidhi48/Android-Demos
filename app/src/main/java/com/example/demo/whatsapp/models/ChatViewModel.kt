package com.example.demo.whatsapp.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatViewModel: ViewModel() {
    var sentMessage = MutableLiveData<String>()
    val receivedMessage = MutableLiveData<String>()
}