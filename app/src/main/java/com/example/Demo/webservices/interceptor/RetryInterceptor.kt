package com.example.demo.webservices.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RetryInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var response: Response?
        var retryCount = 0
        while (retryCount < 3) {
            try {
                response = chain.proceed(chain.request())
                if (response.isSuccessful) {
                    return response
                }
            } catch (e: Exception) {
                Log.d("count", "$retryCount")
                retryCount++
            }
        }
        throw RuntimeException("Request failed.")
    }
}