package com.example.demo.webservices.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class APIInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader(
            "Authorization",
            ""
        ).build()

        val response = chain.proceed(request)
        // If response is unauthorized and Authorization header already exist, Logout user.
        if (response.code == 401 && response.header("Authorization") != null) {
            Log.d("error", "No network connection")
        }
        return response
    }
}