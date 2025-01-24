package com.example.newsfinalapp.di

import com.example.newsfinalapp.Fragments.BaseScreen.BaseViewModel
import com.example.newsfinalapp.Fragments.NewsDetailedScreen.NewsDetailedState
import com.example.newsfinalapp.Fragments.NewsDetailedScreen.NewsDetailedViewModel
import com.example.newsfinalapp.Fragments.StartScreen.StartViewModel
import com.example.newsfinalapp.Model.AppDatabase
import com.example.newsfinalapp.data.api.NewsApi
import com.example.newsfinalapp.data.repository.NewsRepository
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

private fun getNewsApi(retrofit: Retrofit) =
    retrofit.create<NewsApi>( NewsApi::class.java )

private fun getNewsDao(database: AppDatabase) =
    database.newsDAO()

val newsModules = module {
    single {
        NewsRepository(getNewsApi(get()), getNewsDao(get()))
    }

    viewModel {
        BaseViewModel(
            get()
        )
    }

    viewModel {
        StartViewModel()
    }

    viewModel {
        NewsDetailedViewModel(
            get()
        )
    }
}