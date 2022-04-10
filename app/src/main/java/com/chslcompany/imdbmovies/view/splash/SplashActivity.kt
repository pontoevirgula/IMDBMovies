package com.chslcompany.imdbmovies.view.splash

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.chslcompany.imdbmovies.core.di.apiModule
import com.chslcompany.imdbmovies.core.di.dbModule
import com.chslcompany.imdbmovies.core.di.networkModule
import com.chslcompany.imdbmovies.core.di.viewModelModule
import com.chslcompany.imdbmovies.databinding.ActivitySplashBinding
import com.chslcompany.imdbmovies.view.main.MainActivity
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            initApp()
        }, 2000)
    }

    private fun initApp() {
        initKoinApplication(application)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun initKoinApplication(application: Application){
        startKoin {
            androidContext(application.applicationContext)
            modules(
                listOf(
                    apiModule,
                    networkModule,
                    dbModule,
                    viewModelModule
                )
            )
        }
    }
}