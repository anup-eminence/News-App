package com.tejscore.newsapp.api

import com.tejscore.newsapp.data.model.NewsResponse
import com.tejscore.newsapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewApi {

    @GET(Constants.URl.EVERYTHING)
    fun getNews(
        @Query("q") search : String,
        @Query("sortBy") sortBy : String,
        @Query("apiKey") apiKey : String,
        @Query("pageSize") pageSize : String,
        @Query("page") page : String
    ) : NewsResponse
}