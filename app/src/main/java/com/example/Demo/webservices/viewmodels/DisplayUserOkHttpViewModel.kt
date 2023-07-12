package com.example.demo.webservices.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.webservices.interceptor.APIInterceptor
import com.example.demo.webservices.models.UserResponse
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import java.io.IOException

class DisplayUserOkHttpViewModel: ViewModel() {

    private val _users = MutableLiveData<List<UserResponse>>()
    var users: LiveData<List<UserResponse>> = _users

    fun getUser() {
        val client = OkHttpClient().newBuilder().addInterceptor(APIInterceptor()).build()
        val request = Request.Builder()
            .url("https://64a3a5b5c3b509573b565cfc.mockapi.io/UserUpdate")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("response", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val usersList = ArrayList<UserResponse>()
                val jsonData = response.body?.string()
                val jsonArray = JSONArray(jsonData)
                for(i in 0 until jsonArray.length()) {
                    usersList.add(
                        UserResponse(
                            jsonArray.getJSONObject(i).getString("id"),
                            jsonArray.getJSONObject(i).getString("email"),
                            jsonArray.getJSONObject(i).getString("username"),
                            jsonArray.getJSONObject(i).getString("password"),
                        )
                    )
                }
                _users.postValue(usersList)
            }
        })
    }
}