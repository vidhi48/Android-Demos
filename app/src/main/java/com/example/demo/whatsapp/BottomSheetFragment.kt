package com.example.demo.whatsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentBottomSheetBinding
import com.example.demo.whatsapp.models.BottomSheet
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment(whatsappChatFragment: WhatsappChatFragment) :
    BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomSheet()
    }

    private fun setupBottomSheet() = with(binding) {
        val documentButton = BottomSheet(
            AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.baseline_contact_page_24
            ), "Document"
        )
        document = documentButton

        val cameraButton = BottomSheet(
            AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.baseline_camera_alt_24
            ), "Camera"
        )
        camera = cameraButton

        val galleryButton = BottomSheet(
            AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.baseline_image_search_24
            ), "Gallery"
        )
        gallery = galleryButton

        val audioButton = BottomSheet(
            AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.baseline_headphones_24
            ), "Audio"
        )
        audio = audioButton

        val locationButton = BottomSheet(
            AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.baseline_location_on_24
            ), "Location"
        )
        location = locationButton

        val paymentButton = BottomSheet(
            AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.baseline_currency_rupee_24
            ), "Payment"
        )
        payment = paymentButton

        val contactButton = BottomSheet(
            AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.baseline_person_24
            ), "Contact"
        )
        contact = contactButton

        val pollButton = BottomSheet(
            AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.baseline_graphic_eq_24
            ), "Poll"
        )
        poll = pollButton

        cameraBtn.button.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        audioBtn.button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://open.spotify.com/"))
            startActivity(intent)
        }

        locationBtn.button.setOnClickListener {
            val location = Uri.parse("geo:23.028602304078483, 72.4994533962854")
            val intent = Intent(Intent.ACTION_VIEW, location)
            startActivity(intent)
        }

        contactBtn.button.setOnClickListener {
            val phoneNumber = Uri.parse("tel:9532544328")
            val intent = Intent(Intent.ACTION_VIEW, phoneNumber)
            startActivity(intent)
        }
    }
}