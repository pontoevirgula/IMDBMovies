package com.chslcompany.imdbmovies.view.favorite

import androidx.lifecycle.ViewModel
import com.chslcompany.imdbmovies.repository.MovieRepository

class FavoriteViewModel(repository: MovieRepository) : ViewModel() {

    val listFavoriteMovies = repository.getListFavoriteMovies()
}