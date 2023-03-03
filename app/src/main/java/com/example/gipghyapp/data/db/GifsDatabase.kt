package com.example.gipghyapp.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class GifsDatabase: RoomDatabase() {
    abstract fun getGifsDao(): GifDao

    companion object {
        @Volatile
        private var instance: GifsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context): GifsDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                GifsDatabase::class.java,
                "gifs_database"
            ).build()
        }


    }
}