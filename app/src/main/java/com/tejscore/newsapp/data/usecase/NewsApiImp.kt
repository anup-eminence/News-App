package com.tejscore.newsapp.data.usecase

import com.tejscore.newsapp.api.NewApi
import com.tejscore.newsapp.data.model.NewsResponse
import com.tejscore.newsapp.data.repository.NewsRepository
import javax.inject.Inject

class NewsApiImp @Inject constructor(
    private val newsApi: NewApi
) : NewsRepository {

    override fun getNews(
        search: String,
        sortBy: String,
        apiKey: String,
        pageSize: String,
        page: String
    ): NewsResponse {
        return newsApi.getNews(
            search, sortBy, apiKey, pageSize, page
        )
    }
}