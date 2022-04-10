package com.chslcompany.imdbmovies.core.di

import android.app.Application
import androidx.room.Room
import com.chslcompany.imdbmovies.core.db.MovieDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {

    fun providerDatabase(application: Application) : MovieDatabase {
        return Room.databaseBuilder(application,
                MovieDatabase::class.java,"movie.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun providerDao(database: MovieDatabase) = database.moviesDao()

    single { providerDatabase(androidApplication()) }
    single { providerDao(get()) }
}