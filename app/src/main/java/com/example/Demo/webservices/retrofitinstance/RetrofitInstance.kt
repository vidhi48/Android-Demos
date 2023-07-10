package com.example.demo.webservices.retrofitinstance

import com.example.demo.webservices.interfaces.UserInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val getUserApi: UserInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserInterface::class.java)
    }

    val registerApi: UserInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://64a3a5b5c3b509573b565cfc.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserInterface::class.java)
    }
}