package com.example.procore.domin

import com.example.procore.domin.entity.Pokemon

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
fun interface PokemonRepository {
    suspend fun getAllPokemons(page:Int): List<Pokemon>

}