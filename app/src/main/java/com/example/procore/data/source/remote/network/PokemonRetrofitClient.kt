package com.example.procore.data.source.remote.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
object PokemonRetrofitClient {

    const val BASE_URL = "https://api.pokemontcg.io/v2/"

     fun create(): PokemonApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build().create<PokemonApiService>(PokemonApiService::class.java)
    }
}



