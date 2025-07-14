package com.example.procore.data.source.remote.network


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
object PokemonRetrofitClient {

    const val BASE_URL = "https://api.pokemontcg.io/v2/"

    fun create(): PokemonApiService {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor)
        }.build()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build().create<PokemonApiService>(PokemonApiService::class.java)
    }
}



