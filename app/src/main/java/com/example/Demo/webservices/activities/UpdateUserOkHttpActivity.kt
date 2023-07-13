package com.example.demo.webservices.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.androidproject.databinding.ActivityUpdateUserOkHttpBinding
import com.example.demo.webservices.models.UserResponse
import com.example.demo.webservices.viewmodels.UpdateUserOkHttpViewModel

class UpdateUserOkHttpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateUserOkHttpBinding
    private val viewModel: UpdateUserOkHttpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUserOkHttpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        val id = intent.getStringExtra("id")
        id?.let { viewModel.getUser(it) }

        viewModel.user.observe(this) { user ->
            binding.user = user
        }

        viewModel.updatedUser.observe(this) {
            Toast.makeText(this, "User Updated Successfully", Toast.LENGTH_SHORT).show()
        }

        viewModel.isDelete.observe(this) {
            clearText()
        }

        binding.updateBtn.setOnClickListener {
            updateUser()
        }

        binding.deleteBtn.setOnClickListener {
            showAlertDialog()
        }

        binding.displayBtn.setOnClickListener {
            val intent = Intent(this, DisplayUserOkHttpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateUser() {
        viewModel.updateUser(
            UserResponse(
                id = binding.id.text.toString(),
                username = binding.name.text.toString(),
                email = binding.email.text.toString(),
                password = binding.password.text.toString()
            )
        )
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("User")
        builder.setMessage("Are you sure you want to delete this user?")
        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteUser(binding.id.text.toString())
            Toast.makeText(
                this,
                binding.name.text.toString() + " Deleted successfully!",
                Toast.LENGTH_SHORT
            ).show()
        }
        builder.setNegativeButton("No") { dialogInterface, _ ->
            dialogInterface.cancel()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    private fun clearText() = with(binding) {
        id.setText("")
        name.setText("")
        email.setText("")
        password.setText("")
    }
}