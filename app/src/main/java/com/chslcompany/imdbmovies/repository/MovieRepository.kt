package com.chslcompany.imdbmovies.repository

import androidx.lifecycle.LiveData
import com.chslcompany.imdbmovies.model.Favorite
import com.chslcompany.imdbmovies.model.Results

interface MovieRepository {
    fun getListMovies(): List<Results>

    suspend fun getMovies(): MutableList<Results>?

    fun getListFavoriteMovies(): LiveData<List<Results>>

    fun addFavoriteMovies(id: Favorite)

    fun verifyFavoriteMovie(id: String): LiveData<Favorite>

    fun removeFavoriteMovies(id: String)
}