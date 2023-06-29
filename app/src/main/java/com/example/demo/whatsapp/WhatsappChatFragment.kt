package com.example.demo.whatsapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.databinding.FragmentWhatsappChatBinding
import com.example.demo.whatsapp.adapters.WhatsAppChatAdapter
import com.example.demo.whatsapp.models.ChatViewModel

class WhatsappChatFragment : Fragment() {

    private lateinit var binding: FragmentWhatsappChatBinding
    private lateinit var adapter: WhatsAppChatAdapter
    private val viewModel: ChatViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWhatsappChatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateBack()
        setupButtons()
        setupRecyclerView()
    }

    private fun navigateBack() {
        binding.back.setOnClickListener {
            val intent = Intent(requireContext(), WhatsAppActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

    private fun setupButtons() = with(binding) {
        camera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        chip.setOnClickListener {
            val dialog = BottomSheetFragment(this@WhatsappChatFragment)
            dialog.show(parentFragmentManager, "data")
        }
    }

    private fun setupRecyclerView() {

        adapter = WhatsAppChatAdapter(viewModel.message.value?.toMutableList() ?: mutableListOf())
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.chatRecycler.layoutManager = layoutManager
        binding.chatRecycler.adapter = adapter

        viewModel.message.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.send.setOnClickListener {
            val messageContent = binding.message.text.toString().trim()
            if (messageContent.isNotEmpty()) {
                viewModel.sentMessage(binding.message.text.toString().trim())
                binding.message.text.clear()
                autoResponse()
            }
        }
    }

    private fun autoResponse() {
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.receiveMessage("Hello")
        }, 1000)
    }
}