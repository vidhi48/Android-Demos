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
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.databinding.FragmentWhatsappChatBinding
import com.example.demo.whatsapp.adapters.WhatsAppChatAdapter
import com.example.demo.whatsapp.models.ChatModel
import com.example.demo.whatsapp.models.ChatViewModel

class WhatsappChatFragment : Fragment() {

    private lateinit var binding: FragmentWhatsappChatBinding
    private val messages = ArrayList<ChatModel>()
    private lateinit var adapter: WhatsAppChatAdapter
    private val viewModel: ChatViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWhatsappChatBinding.inflate(layoutInflater)
        navigateBack()
        setupButtons()
        setupRecyclerView()
        return binding.root
    }

    private fun navigateBack() {
        binding.back.setOnClickListener {
            val intent = Intent(requireContext(), WhatsAppActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

    private fun setupButtons() {
        binding.camera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        binding.chip.setOnClickListener {
            val dialog = BottomSheetFragment(this)
            dialog.show(parentFragmentManager, "data")
        }
    }

    private fun setupRecyclerView() {

        messages.add(ChatModel("Hello", WhatsAppChatAdapter.MessageType.SEND))
        messages.add(ChatModel("Hii", WhatsAppChatAdapter.MessageType.RECEIVE))
        messages.add(ChatModel("Thank You!", WhatsAppChatAdapter.MessageType.SEND))
        messages.add(ChatModel("Welcome", WhatsAppChatAdapter.MessageType.RECEIVE))

        adapter = WhatsAppChatAdapter(messages)
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.chatRecycler.layoutManager = layoutManager
        binding.chatRecycler.adapter = adapter

        binding.send.setOnClickListener {
            val messageContent = binding.message.text.toString().trim()
            viewModel.sentMessage.value = messageContent
            if (messageContent.isNotEmpty()) {
                adapter.addMessage(
                    ChatModel(
                        binding.message.text.toString(), WhatsAppChatAdapter.MessageType.SEND
                    )
                )
                adapter.notifyItemInserted(messages.size - 1)
                binding.message.text.clear()
                autoResponse(WhatsAppChatAdapter.MessageType.SEND)
            }
        }
    }

    private fun autoResponse(senderType: WhatsAppChatAdapter.MessageType) {
        Handler(Looper.getMainLooper()).postDelayed({
            adapter.addMessage(
                ChatModel(
                    when (senderType) {
                        WhatsAppChatAdapter.MessageType.SEND -> "Hello !"
                        WhatsAppChatAdapter.MessageType.RECEIVE -> "Hello !"
                    }, WhatsAppChatAdapter.MessageType.RECEIVE
                )
            )
        }, 1000)
    }
}