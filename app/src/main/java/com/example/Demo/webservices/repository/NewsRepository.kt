package com.example.demo.webservices.repository

import com.example.demo.webservices.interfaces.UserInterface
import com.example.demo.webservices.models.News

class NewsRepository(private val newsService: UserInterface) {

    suspend fun getNews(): News? {
        return newsService.getNews().body()
    }
}