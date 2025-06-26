package com.example.procore.data.repostiory

import com.example.procore.data.source.remote.mapper.toEntity
import com.example.procore.data.source.remote.network.PokemonApiService
import com.example.procore.domin.PokemonRepository
import com.example.procore.domin.model.Pokemon
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
class PokemonRepositoryImp @Inject constructor(val pokemonApiService: PokemonApiService) :
    PokemonRepository {


    override suspend fun getAllPokemons(): List<Pokemon> {
        val response = pokemonApiService.getPokemons()
        if (response.isSuccessful)
            return response.body()?.toEntity().orEmpty()
        else
            throw Exception("Failed To Get Data")
    }


}