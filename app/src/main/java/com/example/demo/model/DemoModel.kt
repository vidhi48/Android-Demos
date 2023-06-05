package com.example.demo.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.myapplication.BR

class DemoModel: BaseObservable() {

    @get:Bindable
    var username: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.username)
        }
}