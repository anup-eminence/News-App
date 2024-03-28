package com.tejscore.newsapp.di

import com.tejscore.newsapp.data.repository.NewsRepository
import com.tejscore.newsapp.data.usecase.NewsApiImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsRepository() : NewsRepository {
        return NewsApiImp(NetworkModule.provideNewsApi())
    }
}