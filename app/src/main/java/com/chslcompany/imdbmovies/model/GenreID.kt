package com.chslcompany.imdbmovies.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre_id")
data class GenreID(
    @PrimaryKey
    val id: Int? = 0
)
