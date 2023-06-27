package com.example.demo.whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentChatBinding
import com.example.demo.whatsapp.adapters.ChatAdapter
import com.example.demo.whatsapp.models.Chat

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val chatList = mutableListOf<Chat>()
    private lateinit var adapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(layoutInflater)
        setupRecyclerView()
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun setupRecyclerView() {
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
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_image),"Michel", "hello", "11.00 am")
        )

        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat2),"Heta", "How are you?", "06.00 am")
        )

        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat3),"Salena", "did you finish assigned task ?", "08.12 pm")
        )
        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat4),"Justin", "okay", "12/06/2023")
        )
        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_image),"Navin", "hello", "11.00 am")
        )

        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat2),"Kevin", "How are you?", "06.00 am")
        )

        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat3),"Taylor", "did you finish assigned task ?", "08.12 pm")
        )
        chatList.add(
            Chat(
                AppCompatResources.getDrawable(requireContext(), R.drawable.profile_chat4),"Vidhi", "okay", "12/06/2023")
        )

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.chartRecycler.layoutManager = layoutManager

        adapter = ChatAdapter(chatList)
        binding.chartRecycler.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val searchItem = menu.findItem(R.id.search)
        searchItem.isVisible = true
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterData(newText)
                return true
            }
        })
    }

    private fun filterData(query: String) {
        val filteredList = mutableListOf<Chat>()

        chatList.forEach { item ->
            if (item.name.contains(query, ignoreCase = true)) {
                filteredList.add(item)
            }
        }
        adapter.filterList(filteredList)
    }
}