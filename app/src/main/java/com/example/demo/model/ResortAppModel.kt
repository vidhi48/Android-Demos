package com.example.demo.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.myapplication.BR

class ResortAppModel(): BaseObservable() {

    @get: Bindable
    var destination: String = "new data"
        set(value) {
            field = value
            notifyPropertyChanged(BR.destination)
        }
}