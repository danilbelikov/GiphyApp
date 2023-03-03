package com.example.gipghyapp.data.api

import javax.inject.Inject

class TestRepo @Inject constructor(private val gifsService: GiphyService) {

    suspend fun getAll() = gifsService.getSearch()
}