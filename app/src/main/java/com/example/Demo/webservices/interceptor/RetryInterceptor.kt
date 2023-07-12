package com.example.demo.webservices.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RetryInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var response = chain.proceed(request)
        var tryCount = 0
        while (!response.isSuccessful && tryCount < 3) {
            Log.d("interceptor", "Request is not successful $tryCount")
            tryCount++
            response.close()
            response = chain.proceed(request)
        }
        return response
    }
}