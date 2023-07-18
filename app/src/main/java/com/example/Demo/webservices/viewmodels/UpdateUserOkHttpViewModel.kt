package com.example.demo.webservices.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.webservices.interceptor.RetryInterceptor
import com.example.demo.webservices.models.UserResponse
import com.google.gson.Gson
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okio.IOException
import org.json.JSONObject

class UpdateUserOkHttpViewModel : ViewModel() {

    private var _isDelete = MutableLiveData<Boolean>()
    var isDelete: LiveData<Boolean> = _isDelete

    private var _user = MutableLiveData<UserResponse>()
    var user: LiveData<UserResponse> = _user

    private var _updatedUser = MutableLiveData<UserResponse>()
    var updatedUser: LiveData<UserResponse> = _updatedUser

    fun getUser(id: String) {
        val client = OkHttpClient()
            .newBuilder()
            .addInterceptor(RetryInterceptor())
            .build()

        val request =
            Request.Builder().url("https://64a3a5b5c3b509573b565cfc.mockapi.io/UserUpdate/$id")
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("response", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { responseString ->
                    val json = JSONObject(responseString)
                    val userData = UserResponse(
                        json.getString("id"),
                        json.getString("username"),
                        json.getString("email"),
                        json.getString("password"),
                    )
                    _user.postValue(userData)
                }
            }
        })
    }

    fun updateUser(user: UserResponse) {
        val gson = Gson()
        val bodyString = gson.toJson(user)
        val body: RequestBody = bodyString.toRequestBody("application/json".toMediaTypeOrNull())
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://64a3a5b5c3b509573b565cfc.mockapi.io/UserUpdate/${user.id}")
            .put(body)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("fail", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { responseData ->
                    val jsonData = JSONObject(responseData)
                    viewModelScope.launch {
                        _updatedUser.value = UserResponse(
                            jsonData.getString("id"),
                            jsonData.getString("username"),
                            jsonData.getString("email"),
                            jsonData.getString("password"),
                        )
                    }
                }
            }
        })
    }

    fun deleteUser(id: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://64a3a5b5c3b509573b565cfc.mockapi.io/UserUpdate/$id")
            .delete()
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("response", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    viewModelScope.launch {
                        _isDelete.value = true
                    }
                }
            }
        })
    }
}