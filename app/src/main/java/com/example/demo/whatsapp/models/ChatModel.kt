package com.example.demo.whatsapp.models

import com.example.demo.whatsapp.adapters.WhatsAppChatAdapter

data class ChatModel(val message: String, val messageType: WhatsAppChatAdapter.MessageType)