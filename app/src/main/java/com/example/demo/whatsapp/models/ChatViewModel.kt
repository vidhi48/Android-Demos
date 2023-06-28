package com.example.demo.whatsapp.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.whatsapp.adapters.WhatsAppChatAdapter

class ChatViewModel: ViewModel() {

    private val _messages = MutableLiveData<List<ChatModel>>(emptyList())
    val message: LiveData<List<ChatModel>> = _messages

    init {
        sentMessage("Hello")
        receiveMessage("Hii")
        sentMessage("Thank You!")
        receiveMessage("Welcome")
    }

    fun sentMessage(message: String) {
        _messages.value = _messages.value?.plus(ChatModel(message, WhatsAppChatAdapter.MessageType.SEND))
    }

    fun receiveMessage(message: String) {
        _messages.value = _messages.value?.plus(ChatModel(message, WhatsAppChatAdapter.MessageType.RECEIVE))
    }
}