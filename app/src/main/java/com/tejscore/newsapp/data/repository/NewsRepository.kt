package com.tejscore.newsapp.data.repository

import com.tejscore.newsapp.data.model.NewsResponse
import retrofit2.http.Query

interface NewsRepository {

    fun getNews(
        search: String,
        sortBy: String,
        apiKey: String,
        pageSize: String,
        page: String
    ): NewsResponse
}