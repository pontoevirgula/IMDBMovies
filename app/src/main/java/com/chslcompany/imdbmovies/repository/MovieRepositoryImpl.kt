package com.chslcompany.imdbmovies.repository

import com.chslcompany.imdbmovies.core.db.MovieDAO
import com.chslcompany.imdbmovies.model.Favorite
import com.chslcompany.imdbmovies.model.Results
import com.chslcompany.imdbmovies.service.MovieAPI

class MovieRepositoryImpl(
    private val api: MovieAPI,
    private val dao: MovieDAO
) : MovieRepository {

    override fun getListMovies() = dao.findAllMovies()

    override suspend fun getMovies() : MutableList<Results>?{
        val movies = api.getAllMovies("","pt-BR","popularity.desc")
        movies.results?.let { dao.addMovies(it) }
        return movies.results
    }

    override fun getListFavoriteMovies() = dao.findAllFavoriteMovies()

    override fun addFavoriteMovies(id: Favorite) = dao.addFavoriteMovie(id)

    override fun verifyFavoriteMovie(id: String) = dao.verifyFavoriteMovie(id)

    override fun removeFavoriteMovies(id: String) = dao.removeFavoriteMovies(id)


}