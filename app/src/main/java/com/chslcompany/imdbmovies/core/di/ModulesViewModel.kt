package com.chslcompany.imdbmovies.core.di

import com.chslcompany.imdbmovies.core.db.MovieDAO
import com.chslcompany.imdbmovies.repository.MovieRepositoryImpl
import com.chslcompany.imdbmovies.service.MovieAPI
import com.chslcompany.imdbmovies.view.detail.DetailViewModel
import com.chslcompany.imdbmovies.view.favorite.FavoriteViewModel
import com.chslcompany.imdbmovies.view.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(providerMovieRepository(get(),get()))
    }
    viewModel {
        FavoriteViewModel(providerMovieRepository(get(),get()))
    }
    viewModel {
       DetailViewModel(providerMovieRepository(get(),get()))
    }
}

fun providerMovieRepository(api: MovieAPI, dao: MovieDAO): MovieRepositoryImpl{
    return MovieRepositoryImpl(api,dao)
}