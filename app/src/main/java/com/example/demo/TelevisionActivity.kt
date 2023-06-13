package com.example.demo

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.example.androidproject.R
import com.example.androidproject.databinding.ActivityTelevisionBinding
import com.example.demo.models.AppBarModel
import com.example.demo.models.ButtonImageModel
import com.example.demo.models.MusicControlModel

class TelevisionActivity : AppCompatActivity() {

    lateinit var binding: ActivityTelevisionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelevisionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupPowerButton()
        setupMusicButton()
        setupButtons()
        setupCustomViewButtons()
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

    private fun setupButtons() {
        binding.back.setOnClickListener{
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }

        binding.home.setOnClickListener{
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }

        binding.exit.setOnClickListener{
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clickedButton(button: ImageButton) {

        binding.remoteCustom.upButton.drawable.mutate()
            .setTint(applicationContext.getColor(R.color.grayIcon))
        binding.remoteCustom.leftButton.drawable.mutate()
            .setTint(applicationContext.getColor(R.color.grayIcon))
        binding.remoteCustom.rightButton.drawable.mutate()
            .setTint(applicationContext.getColor(R.color.grayIcon))
        binding.remoteCustom.downButton.drawable.mutate()
            .setTint(applicationContext.getColor(R.color.grayIcon))

        button.drawable.mutate().setTint(applicationContext.getColor(R.color.blue))

    }

    private fun setupCustomViewButtons() {
        binding.remoteCustom.upButton.setOnClickListener{
            clickedButton(binding.remoteCustom.upButton)
        }

        binding.remoteCustom.downButton.setOnClickListener{
            clickedButton(binding.remoteCustom.downButton)
        }

        binding.remoteCustom.leftButton.setOnClickListener{
            clickedButton(binding.remoteCustom.leftButton)
        }

        binding.remoteCustom.rightButton.setOnClickListener{
            clickedButton(binding.remoteCustom.rightButton)
        }
    }

    private fun setupViews() {

        binding.appBar.appToolBar.setNavigationOnClickListener {
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }

        val appBarData = AppBarModel(R.string.tvAppBar, R.string.tvAppSub)
        binding.actionbar = appBarData

        val musicControl = MusicControlModel(
            AppCompatResources.getDrawable(this, R.drawable.rewind),
            AppCompatResources.getDrawable(this, R.drawable.fastforward)
        )
        binding.musicControlCard = musicControl

        val keyboardButton = ButtonImageModel(
            AppCompatResources.getDrawable(this, R.drawable.baseline_keyboard_24),
            AppCompatResources.getDrawable(this, R.drawable.baseline_navigate_next_24),
            R.string.keyboard
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


