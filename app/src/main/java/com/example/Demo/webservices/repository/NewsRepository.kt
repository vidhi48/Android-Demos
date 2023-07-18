package com.example.demo.webservices.repository

import com.example.demo.webservices.interfaces.UserService
import com.example.demo.webservices.models.News

class NewsRepository(private val newsService: UserService) {

    suspend fun getNews(): News? {
        return newsService.getNews().body()
    }
}