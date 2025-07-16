package com.example.procore.data.source.remote.network

import com.example.procore.data.source.remote.dto.PokemonDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
fun interface PokemonApiService {

    @GET("cards?pageSize=50")
    suspend fun getPokemons(@Query("page") page: Int): Response<PokemonDto>
}