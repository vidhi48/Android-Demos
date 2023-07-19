package com.example.demo.webservices.retrofitinstance

import com.example.demo.webservices.interceptor.APIInterceptor
import com.example.demo.webservices.interfaces.UserService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val client = OkHttpClient().newBuilder().addInterceptor(APIInterceptor()).build()
    val getUserApi: UserService by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(UserService::class.java)
    }

    val registerApi: UserService by lazy {
        Retrofit.Builder()
            .baseUrl("https://64a3a5b5c3b509573b565cfc.mockapi.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserService::class.java)
    }
}