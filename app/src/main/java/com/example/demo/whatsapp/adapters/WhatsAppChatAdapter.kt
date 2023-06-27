package com.example.demo.whatsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemReceiveMessageTextBinding
import com.example.androidproject.databinding.ItemSendMessageTextBinding
import com.example.demo.whatsapp.models.ChatModel

class WhatsAppChatAdapter(private var chatList: ArrayList<ChatModel>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class SendMessage(private val binding: ItemSendMessageTextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: ChatModel) {
            binding.messageSend = message
        }
    }

    class ReceiveMessage(private val binding: ItemReceiveMessageTextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: ChatModel) {
            binding.messageReceived = message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (MessageType.values()[viewType]) {
            MessageType.SEND -> {
                val sendBinding =
                    ItemSendMessageTextBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                SendMessage(sendBinding)

            }

            MessageType.RECEIVE -> {
                val receiveBinding = ItemReceiveMessageTextBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ReceiveMessage(receiveBinding)
            }
        }
    }

    fun addMessage(message: ChatModel) {
        chatList.add(message)
        notifyItemInserted(chatList.count())
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SendMessage -> holder.bind(chatList[position])
            is ReceiveMessage -> holder.bind(chatList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
       return when (chatList[position].messageType) {
           MessageType.SEND -> MessageType.SEND.ordinal
           MessageType.RECEIVE -> MessageType.RECEIVE.ordinal
       }
    }

    enum class MessageType {
        SEND, RECEIVE
    }
}