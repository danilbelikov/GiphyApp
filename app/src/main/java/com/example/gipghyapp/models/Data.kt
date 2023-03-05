package com.example.gipghyapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gifs")
data class Data(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val analytics: Analytics,
    val analytics_response_payload: String,
    val bitly_gif_url: String,
    val bitly_url: String,
    val content_url: String,
    val embed_url: String,
    val images: Images,
    val import_datetime: String,
    val is_sticker: Int,
    val rating: String,
    val slug: String,
    val source: String,
    val source_post_url: String,
    val source_tld: String,
    val title: String,
    val trending_datetime: String,
    val type: String,
    val url: String,
    val user: User,
    val username: String
)