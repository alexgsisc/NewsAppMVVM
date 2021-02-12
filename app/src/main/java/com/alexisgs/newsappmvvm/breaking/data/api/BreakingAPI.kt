package com.alexisgs.newsappmvvm.breaking.data.api

import com.alexisgs.newsappmvvm.breaking.data.models.BreakingResponse
import com.alexisgs.newsappmvvm.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  Created by Alexis Guadarrama on 2/10/21.
 */
interface BreakingAPI {

    @GET("/top-headlines")
    suspend fun getBreakingNews(
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int = 1,
        @Query("apikey") apiKey: String = API_KEY
    ): Response<BreakingResponse>

    @GET("/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String,
        @Query("from") pageNumber: Int = 1,
        @Query("apikey") apiKey: String = API_KEY
    ): Response<BreakingResponse>
}