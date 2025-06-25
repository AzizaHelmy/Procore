package com.example.procore.data.source.remote.network

import com.example.procore.data.source.remote.model.PokemonDto
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
fun interface PokemonApiService {

    @GET("cards")
    suspend fun getPokemons(): Response<PokemonDto>
}