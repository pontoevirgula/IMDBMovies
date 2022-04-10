package com.chslcompany.imdbmovies.model

import androidx.room.TypeConverter
import com.google.gson.Gson

class GenreConverter {

    @TypeConverter
    fun listToJson(value: List<GenreID>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<GenreID>? {

        val objects = Gson().fromJson(value, Array<GenreID>::class.java) as Array<GenreID>
        return objects.toList()
    }
}