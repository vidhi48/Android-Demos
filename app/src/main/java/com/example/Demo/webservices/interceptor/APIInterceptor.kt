package com.example.demo.webservices.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class APIInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        when (response.code) {
            in 200..226 ->
                Log.d("Status", "Success")

            else -> Log.d("Status", "Error")
        }
        return response
    }
}