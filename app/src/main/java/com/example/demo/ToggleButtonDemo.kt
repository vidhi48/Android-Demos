package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.ToggleButton
import com.example.myapplication.R
import com.google.android.material.switchmaterial.SwitchMaterial

class ToggleButtonDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toggle_button_demo)
        toggleButtonAction()
        switchAction()
    }

    private fun toggleButtonAction() {
        val toggleButton1 = findViewById<ToggleButton>(R.id.toggleButtonDemo)
        toggleButton1.setOnClickListener{
            if (toggleButton1.isChecked) {
                Toast.makeText(this, "ToggleButton: On", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "ToggleButton: Off", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun switchAction() {
        val switchDemo = findViewById<SwitchMaterial>(R.id.switchDemo)
        switchDemo.setOnClickListener{
            if (switchDemo.isChecked) {
                Toast.makeText(this, "Switch is On", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Switch is Off", Toast.LENGTH_SHORT).show()
            }
        }
    }
}