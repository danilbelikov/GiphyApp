package com.example.gipghyapp.models

data class GiphyResponse(
    val `data`: List<Any>,
    val meta: Meta,
    val pagination: Pagination
)