package com.example.newsfinalapp

import android.app.Application
import com.example.newsfinalapp.Model.databaseProvider
import com.example.newsfinalapp.di.newsModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NewsAppApplication)
            modules(networkModule)
            modules(databaseProvider)
            modules(newsModules)
        }
    }
}