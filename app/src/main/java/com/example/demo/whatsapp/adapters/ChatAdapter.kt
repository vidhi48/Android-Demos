package com.example.demo.whatsapp.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.databinding.ItemChatListBinding
import com.example.demo.whatsapp.WhatAppChatActivity
import com.example.demo.whatsapp.models.Chat

class ChatAdapter(private var chatList: List<Chat>):
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemChatListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            binding.chats = chat
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, WhatAppChatActivity::class.java)
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemChatListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = chatList[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filterList: List<Chat>) {
        chatList = filterList
        notifyDataSetChanged()
    }
}