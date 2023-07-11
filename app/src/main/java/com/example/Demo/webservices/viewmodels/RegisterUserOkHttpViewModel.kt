package com.example.demo.webservices.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.webservices.models.UserRequest
import com.example.demo.webservices.models.UserResponse
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class RegisterUserOkHttpViewModel : ViewModel() {

    private var _validationError = MutableLiveData<String>()
    var validationError: LiveData<String> = _validationError

    private var _response = MutableLiveData<UserResponse>()
    var response: LiveData<UserResponse> = _response
    var data: UserResponse? = null

    fun validate(username: String, email: String, password: String) {
        if (username.isEmpty()) {
            _validationError.value = "Name is Empty"
        } else if (email.isEmpty()) {
            _validationError.value = "Email is Empty"
        } else if (password.isEmpty()) {
            _validationError.value = "Password is empty"
        } else {
            addUser(UserRequest(username, email, password))
        }
    }

    private fun addUser(user: UserRequest) {
        val gson = Gson()
        val bodyString = gson.toJson(user)
        val body: RequestBody = bodyString.toRequestBody("application/json".toMediaTypeOrNull())

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://64a3a5b5c3b509573b565cfc.mockapi.io/UserUpdate")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("response", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                var users = UserResponse()
                response.body?.let { responseString ->
                    val jsonData = JSONObject(responseString.string())
                    users = UserResponse(
                        jsonData.getString("id"),
                        jsonData.getString("username"),
                        jsonData.getString("email"),
                        jsonData.getString("password"),
                    )
                }
                data = users
                _response.postValue(users)
            }
        })
    }
}