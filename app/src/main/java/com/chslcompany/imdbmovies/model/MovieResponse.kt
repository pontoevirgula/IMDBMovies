package com.chslcompany.imdbmovies.model

data class MovieResponse(
    val page: Int ? = 0,
    val total_results: Int ? = 0,
    val total_pages: Int ? = 0,
    val results : MutableList<Results>? = null
)
