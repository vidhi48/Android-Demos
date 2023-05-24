package com.example.demo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class SnackBarDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar_demo)
        buttonActions()
    }

    private fun buttonActions() {
        val snackButton = findViewById<Button>(R.id.snackButton)
        val floatingButton = findViewById<FloatingActionButton>(R.id.floatingButton)

        snackButton.setOnClickListener{
            val snackBar = Snackbar.make(it, "This is a Simple SnackBar", Snackbar.LENGTH_SHORT)
            snackBar.anchorView = floatingButton
            snackBar.setAction("DISMISS"){
                Toast.makeText(this, "SnackBar Dismissed", Toast.LENGTH_SHORT).show()
            }
            snackBar.show()
        }

        floatingButton.setOnClickListener{
            Toast.makeText(this, "Floating action button Tapped", Toast.LENGTH_SHORT).show()
        }
    }
}