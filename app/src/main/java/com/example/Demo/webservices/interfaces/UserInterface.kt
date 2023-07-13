package com.example.demo.webservices.interfaces

import com.example.demo.webservices.models.ImageResponse
import com.example.demo.webservices.models.News
import com.example.demo.webservices.models.User
import com.example.demo.webservices.models.UserRequest
import com.example.demo.webservices.models.UserResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface UserInterface {

    @GET("/api/users")
    fun getUsers(@Query("page") page: String): Call<User>

    @POST("/UserUpdate")
    fun registerUser(@Body user: UserRequest): Call<UserResponse>

    @Multipart
    @POST("upload")
    suspend fun uploadImage(
        @Query("key") key: String,
        @Part image: MultipartBody.Part
    ): ImageResponse

    @GET("top-headlines?country=in&apiKey=67962f7b55de4aa7b22b2307d8c4d73d&pageSize=80")
    suspend fun getNews(): Response<News>
}