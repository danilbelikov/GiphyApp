package com.example.gipghyapp.data.api


import com.example.gipghyapp.utils.Constants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyService {
    @GET("api.giphy.com/v1/gifs/search")
    suspend fun getSearch(
        @Query("q") query: String,
        @Query("limit") limit: Int = 25,
        @Query("apiKey") apiKey: String = API_KEY
    )

}