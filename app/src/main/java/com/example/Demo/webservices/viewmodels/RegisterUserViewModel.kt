package com.example.demo.webservices.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.webservices.models.UserRequest
import com.example.demo.webservices.models.UserResponse
import com.example.demo.webservices.retrofitinstance.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterUserViewModel: ViewModel() {
    private val _registerResponse: MutableLiveData<UserResponse?> = MutableLiveData(null)
    var registerResponse: LiveData<UserResponse?> = _registerResponse
    fun registerUser(username: String, email: String, password: String) {
        RetrofitInstance.registerApi.registerUser(UserRequest(username, email, password)).enqueue(object :
            Callback<UserResponse?> {
            override fun onResponse(
                call: Call<UserResponse?>,
                response: Response<UserResponse?>
            ) {
               _registerResponse.value = response.body()
            }

            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                Log.e("Register", "Registration failed.")
            }
        })
    }
}