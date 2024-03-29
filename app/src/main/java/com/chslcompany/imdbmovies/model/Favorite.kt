package com.chslcompany.imdbmovies.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favorite")
data class Favorite(
    @PrimaryKey
    var id: Int ? = 0
): Serializable
