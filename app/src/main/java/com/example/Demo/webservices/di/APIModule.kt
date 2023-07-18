package com.example.demo.webservices.di

import com.example.demo.webservices.interfaces.UserService
import com.example.demo.webservices.repository.ImageUploadRepository
import com.example.demo.webservices.repository.NewsRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APIModule {

    private const val IMAGE_URL = "https://api.imgbb.com/1/"
    private const val NEWS = "https://newsapi.org/v2/"

    @Provides
    @Singleton
    fun providesGson(): Gson =
        GsonBuilder().create()

    @Provides
    @Singleton
    @Named("IMAGE_UPLOAD")
    fun provideImageUploadRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(IMAGE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

    @Provides
    @Singleton
    @Named("ImageUploadService")
    fun provideImageUploadService(@Named("IMAGE_UPLOAD") retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    @Named("UploadImage")
    fun providesUploadImageRepository(@Named("ImageUploadService") imageService: UserService): ImageUploadRepository =
        ImageUploadRepository(imageService)

    @Provides
    @Singleton
    @Named("NEWS")
    fun provideFetchNews(gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(NEWS)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    @Named("NewsService")
    fun provideNewService(@Named("NEWS") retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    fun provideNewRepository(@Named("NewsService") newsInterface: UserService): NewsRepository =
        NewsRepository(newsInterface)
}