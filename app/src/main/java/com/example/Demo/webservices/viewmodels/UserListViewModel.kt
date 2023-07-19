package com.example.demo.webservices.viewmodels

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.webservices.interceptor.ErrorCallback
import com.example.demo.webservices.models.Data
import com.example.demo.webservices.models.User
import com.example.demo.webservices.retrofitinstance.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListViewModel: ViewModel() {
    private var _userLiveData = MutableLiveData<List<Data>>()
    var userLiveData: LiveData<List<Data>> = _userLiveData
    private val error: ErrorCallback? = null
    fun getUser(context: Context) {
        RetrofitInstance.getUserApi.getUsers("2").enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                _userLiveData.value = response.body()?.data
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                Log.d("error", "Failed.")
                error?.let { showAlertDialog(it.title, it.message, context) }
            }
        })
    }

    private fun showAlertDialog(title: String, message: String, context: Context) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Ok") { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }
}