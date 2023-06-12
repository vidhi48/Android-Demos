package com.example.demo

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityTelevisionScreenBinding
import com.example.demo.models.AppBarModel
import com.example.demo.models.ButtonImageModel
import com.example.demo.models.MusicControlModel

class TelevisionScreen : AppCompatActivity() {

    lateinit var binding: ActivityTelevisionScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelevisionScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupPowerButton()
        setupMusicButton()
        setupViews()
    }

    private fun setupPowerButton() {
        var isOn = false
        binding.card.power.setOnClickListener{
            isOn = !isOn
            if (isOn) {
                binding.card.textOn.setTextColor(Color.GRAY)
                binding.card.textOff.setTextColor(Color.BLACK)
            } else {
                binding.card.textOn.setTextColor(Color.BLACK)
                binding.card.textOff.setTextColor(Color.GRAY)
            }
        }
    }

    private fun setupMusicButton() {
        var isPlaying = false

        binding.card.pause.setOnClickListener {
            isPlaying = !isPlaying
            if (isPlaying) {
                binding.card.pause.setImageResource(R.drawable.play)
            } else {
                binding.card.pause.setImageResource(R.drawable.pause)
            }
        }
    }

    private fun setupViews() {

        binding.appBar.appToolBar.setNavigationOnClickListener {
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }

        val appBarData = AppBarModel("Smart Television", "Sony A9F")
        binding.actionbar = appBarData

        val musicControl = MusicControlModel(
            AppCompatResources.getDrawable(this, R.drawable.rewind),
            AppCompatResources.getDrawable(this, R.drawable.fastforward)
        )
        binding.musicControlCard = musicControl

        val keyboardButton = ButtonImageModel(
            AppCompatResources.getDrawable(this, R.drawable.baseline_keyboard_24),
            AppCompatResources.getDrawable(this, R.drawable.baseline_navigate_next_24),
            "Keyboard"
        )
        binding.keyboardBtn = keyboardButton

        binding.card.button.apply {
            setOnClickListener {
                setupKeyboardButton(it)
            }
            isFocusable = true
            isFocusableInTouchMode = true
        }
    }

    private fun setupKeyboardButton(view: View) {
        val keyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard.showSoftInput(view, InputMethodManager.RESULT_SHOWN)
    }
}