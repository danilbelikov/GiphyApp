package com.example.gipghyapp.data.api


import com.example.gipghyapp.models.GiphyResponse2
import com.example.gipghyapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyService {
    @GET("v1/gifs/search")
    suspend fun getSearch(
        @Query("q") query: String,
        @Query("limit") limit: Int = 25,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<GiphyResponse2>

}