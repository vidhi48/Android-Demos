package com.example.demo.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.myapplication.BR


data class NewApplicationModel(var destination: String, var nights: Int, var guests: Int, var bedrooms: Int)  {

//    @get:Bindable
//    var destination: String = ""
//        set(value) {
//            field = value
//            notifyPropertyChanged(BR.newApplication)
//        }
}