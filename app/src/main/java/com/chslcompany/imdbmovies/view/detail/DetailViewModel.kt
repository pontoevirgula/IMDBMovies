package com.chslcompany.imdbmovies.view.detail

import androidx.lifecycle.ViewModel
import com.chslcompany.imdbmovies.model.Favorite
import com.chslcompany.imdbmovies.repository.MovieRepository

class DetailViewModel (private val repository: MovieRepository) : ViewModel() {

    fun removeFavorite(id: String) = repository.removeFavoriteMovies(id)
    fun addFavorite(favorite: Favorite) = repository.addFavoriteMovies(favorite)
    fun checkFavorite(id: String) = repository.verifyFavoriteMovie(id)



}
