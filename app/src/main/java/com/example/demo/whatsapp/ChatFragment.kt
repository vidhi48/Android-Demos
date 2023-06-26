package com.example.demo.whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentChatBinding
import com.example.demo.whatsapp.adapters.ChatAdapter
import com.example.demo.whatsapp.models.Chat

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(layoutInflater)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val chatList = mutableListOf<Chat>()
        chatList.add(
            Chat(
            AppCompatResources.getDrawable(requireContext(), R.drawable.profile_image),"Sandra Adams", "hello", "11.00 am")
        )

        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat2),"Arijit", "How are you?", "06.00 am")
        )

        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat3),"Sandra", "did you finish assigned task ?", "08.12 pm")
        )
        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat4),"Klaus", "okay", "12/06/2023")
        )
        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_image),"Sandra Adams", "hello", "11.00 am")
        )

        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat2),"Arijit", "How are you?", "06.00 am")
        )

        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat3),"Sandra", "did you finish assigned task ?", "08.12 pm")
        )
        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat4),"Klaus", "okay", "12/06/2023")
        )
        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_image),"Sandra Adams", "hello", "11.00 am")
        )

        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat2),"Arijit", "How are you?", "06.00 am")
        )

        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat3),"Sandra", "did you finish assigned task ?", "08.12 pm")
        )
        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat4),"Klaus", "okay", "12/06/2023")
        )

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.chartRecycler.layoutManager = layoutManager

        val adapter = ChatAdapter(chatList)
        binding.chartRecycler.adapter = adapter
    }
}