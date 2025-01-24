package com.example.newsfinalapp.Model

import android.content.Context
import android.provider.ContactsContract.Data
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseProvider = module {
    single {
        getDatabase(androidContext())
    }
}

fun getDatabase(context: Context) = Room.databaseBuilder(
    context,
    AppDatabase::class.java,
    "app_database"
).build()
