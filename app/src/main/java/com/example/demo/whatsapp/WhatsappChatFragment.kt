package com.example.demo.whatsapp

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentWhatsappChatBinding
import com.example.demo.whatsapp.adapters.WhatsAppChatAdapter
import com.example.demo.whatsapp.models.ChatViewModel

class WhatsappChatFragment : Fragment() {

    private lateinit var binding: FragmentWhatsappChatBinding
    private lateinit var adapter: WhatsAppChatAdapter
    private val viewModel: ChatViewModel by viewModels()
    private val channelId = "channel"

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
                sendNotification()
            }
        }
    }

    private fun autoResponse() {
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.receiveMessage("Hello! wassup?")
        }, 1000)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification() {
        createNotificationChannel()
        val intent = Intent(requireContext(), WhatsappChatFragment::class.java)
        val pendingIntent =
            PendingIntent.getActivity(requireContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE)
        val bitmap = BitmapFactory.decodeResource(context?.resources, R.drawable.profile_chat4)
        val notificationBuilder = NotificationCompat.Builder(requireContext(), channelId)
            .setSmallIcon(R.drawable.baseline_message_24)
            .setContentTitle(getString(R.string.sandra_adams))
            .setContentText(getString(R.string.messageContent))
            .setLargeIcon(bitmap)
            .addAction(R.drawable.baseline_reply_24, getString(R.string.reply),null)
            .addAction(R.drawable.baseline_archive_24,getString(R.string.archive), null)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(context?.let { NotificationManagerCompat.from(it) }) {
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            this?.notify(1, notificationBuilder.build())
        }
    }
}