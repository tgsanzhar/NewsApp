package com.example.newsfinalapp

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import kotlin.math.sin

val networkModule = module {
    single {
        OkHttpClient
            .Builder()
            .readTimeout(60_000, TimeUnit.MILLISECONDS)
            .writeTimeout(60_000, TimeUnit.MILLISECONDS)
            .build()
    }
    single {
        Json {
            encodeDefaults = true
        }
    }

    single {
        val json: Json = get()
        val okHttpClient: OkHttpClient = get()

        Retrofit.Builder()
            .baseUrl("https://nfactorial.onrender.com/")
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .addCallAdapterFactory(ResultCallAdapterFactory.create())
            .build()
    }
}
