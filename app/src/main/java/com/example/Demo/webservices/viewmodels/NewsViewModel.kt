package com.example.demo.webservices.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.webservices.models.News
import com.example.demo.webservices.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private var _news = MutableLiveData<News>()
    val news: LiveData<News> = _news

    fun getNews() {
        viewModelScope.launch {
            val news = newsRepository.getNews()
            news?.let {
                _news.value = it
            }
        }
    }
}