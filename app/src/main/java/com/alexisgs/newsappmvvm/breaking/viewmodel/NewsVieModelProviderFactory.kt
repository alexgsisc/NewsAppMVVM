package com.alexisgs.newsappmvvm.breaking.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexisgs.newsappmvvm.breaking.repository.NewsRepository

class NewsVieModelProviderFactory(
    private val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }


}