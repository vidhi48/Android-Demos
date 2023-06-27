package com.example.demo.whatsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentBottomSheetBinding
import com.example.demo.whatsapp.models.BottomSheet
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment(whatsappChatFragment: WhatsappChatFragment) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetBinding.inflate(layoutInflater)
        setupBottomSheet()
        return binding.root
    }

    private fun setupBottomSheet() {
        val documentButton = BottomSheet(AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_contact_page_24), "Document")
        binding.document = documentButton

        val cameraButton = BottomSheet(AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_camera_alt_24), "Camera")
        binding.camera = cameraButton

        val galleryButton = BottomSheet(AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_image_search_24), "Gallery")
        binding.gallery = galleryButton

        val audioButton = BottomSheet(AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_headphones_24), "Audio")
        binding.audio = audioButton

        val locationButton = BottomSheet(AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_location_on_24), "Location")
        binding.location = locationButton

        val paymentButton = BottomSheet(AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_currency_rupee_24), "Payment")
        binding.payment = paymentButton

        val contactButton = BottomSheet(AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_person_24), "Contact")
        binding.contact = contactButton

        val pollButton = BottomSheet(AppCompatResources.getDrawable(requireContext(), R.drawable.baseline_graphic_eq_24), "Poll")
        binding.poll = pollButton
    }
}