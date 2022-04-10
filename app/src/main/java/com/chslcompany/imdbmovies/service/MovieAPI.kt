package com.chslcompany.imdbmovies.service

import com.chslcompany.imdbmovies.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {
//
//    @GET("ComingSoon/{apiKey}")
//    suspend fun getComingSoonMovies(
//        @Path("apiKey") apiKey: String
//    ): ComingSoonMovie
//
//    @GET("Name/{apiKey}/{imdbId}")
//    suspend fun getActorPersonalInfo(
//        @Path("apiKey") apiKey: String,
//        @Path("imdbId") imdbId: String?
//    ): ActorPersonalInfo
//
//    @GET("Top250Movies/{apiKey}")
//    suspend fun getTop250Movies(
//        @Path("apiKey") apiKey: String
//    ): TopMovies
//
//    @GET("MostPopularMovies/{apiKey}")
//    suspend fun getMostPopularMovies(
//        @Path("apiKey") apiKey: String
//    ): MostPopularMovies
//
//    @GET("SearchTitle/{apiKey}/{expression}")
//    fun getSearchTitle(
//        @Path("apiKey") apiKey: String,
//        @Path("expression") expression: String?
//    ): SearchMovieTitle

    @GET("discover/movie")
    suspend fun getAllMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("sort_by") sort_by: String
    ): MovieResponse

}