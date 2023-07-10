package com.example.demo.webservices.viewmodels

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.webservices.models.UserResponse

class UpdateUserViewModel: ViewModel() {

    private var _userUpdate = MutableLiveData<List<UserResponse>>()
    var userUpdate: LiveData<List<UserResponse>> = _userUpdate

    fun updateUser(username: String, email: String, password: String) {

    }
}