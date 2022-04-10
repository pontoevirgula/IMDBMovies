package com.chslcompany.imdbmovies

import android.app.Application
import com.chslcompany.imdbmovies.core.di.apiModule
import com.chslcompany.imdbmovies.core.di.dbModule
import com.chslcompany.imdbmovies.core.di.networkModule
import com.chslcompany.imdbmovies.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

//        startKoin {
//            androidContext(this@KoinApplication)
//            modules(
//                listOf(
//                    apiModule,
//                    networkModule,
//                    dbModule,
//                    viewModelModule
//                )
//            )
//        }
    }
}