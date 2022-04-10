package com.chslcompany.imdbmovies.service

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Requester {

    private const val BASE_URL = "https://imdb-api.com/pt-BR/API/"

    private val gson = GsonBuilder().setLenient().create()

    val service: Retrofit
        get() {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
}