package com.alexisgs.newsappmvvm.breaking.data.models

data class BreakingResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)