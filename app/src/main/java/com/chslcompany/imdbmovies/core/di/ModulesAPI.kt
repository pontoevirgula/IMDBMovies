package com.chslcompany.imdbmovies.core.di

import com.chslcompany.imdbmovies.BuildConfig
import com.chslcompany.imdbmovies.service.MovieAPI
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    fun providerMovieApi(retrofit: Retrofit) : MovieAPI {
        return retrofit.create(MovieAPI::class.java)
    }

    single { providerMovieApi(get()) }
}

val networkModule = module {

    fun provideRetrofit(client: OkHttpClient) : Retrofit =
        Retrofit.Builder().apply {
            baseUrl(BuildConfig.API)
            client(client)
            addConverterFactory(MoshiConverterFactory.create())
        }.build()

    fun providerOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().apply {
            connectTimeout(60L,TimeUnit.SECONDS)
            readTimeout(60L,TimeUnit.SECONDS)
        }.build()

    single { provideRetrofit(get()) }
    single { providerOkHttpClient() }
}
