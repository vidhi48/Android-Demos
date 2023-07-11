package com.example.demo.webservices.interfaces

import com.example.demo.webservices.models.User
import com.example.demo.webservices.models.UserRequest
import com.example.demo.webservices.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserInterface {

    @GET("/api/users")
    fun getUsers(@Query("page") page: String): Call<User>

    @POST("/UserUpdate")
    fun registerUser(@Body user: UserRequest): Call<UserResponse>

}