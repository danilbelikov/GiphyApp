package com.example.gipghyapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.gipghyapp.models.Data
import retrofit2.http.Query

interface GifDao {
    @androidx.room.Query("SELECT * FROM gifs")
    suspend fun getAllGifs(): LiveData<List<Data>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(gif: Data)

    @Delete
    suspend fun delete (gif: Data)


}