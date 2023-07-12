package com.example.demo.webservices.retrofitinstance

import com.example.demo.webservices.interceptor.APIInterceptor
import com.example.demo.webservices.interceptor.RetryInterceptor
import com.example.demo.webservices.interfaces.UserInterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val getUserApi: UserInterface by lazy {
        val interceptorClient = OkHttpClient().newBuilder().addInterceptor(RetryInterceptor()).build()
        Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(interceptorClient)
            .build()
            .create(UserInterface::class.java)
    }

    val registerApi: UserInterface by lazy {
        val client = OkHttpClient().newBuilder().addInterceptor(APIInterceptor()).build()
        Retrofit.Builder()
            .baseUrl("https://64a3a5b5c3b509573b565cfc.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(UserInterface::class.java)
    }
}