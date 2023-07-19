package com.example.demo.webservices.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidproject.databinding.ActivityDisplayUsersBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class DisplayUsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayUsersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun setupUI() {
        binding.loginBtn.setOnClickListener {
            GlobalScope.launch {
                println("Thread: " + Thread.currentThread().name)
                try {
                    sendPostRequest("eve.holt@reqres.in", "cityslicka")
                } catch (ex: Exception) {
                    Log.d("user", "Error")
                }
            }
        }
    }

    private fun sendPostRequest(email: String, password: String) {
        val jsonObj = JSONObject()
        jsonObj.put("email", email)
        jsonObj.put("password", password)
        val url = URL("https://reqres.in/api/login")
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json")
            val data = OutputStreamWriter(outputStream)
            data.write(jsonObj.toString())
            data.flush()
            println("Url: $url, StatusCode: $responseCode")
            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()
                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                println("Response: $response")
            }
        }
    }
}