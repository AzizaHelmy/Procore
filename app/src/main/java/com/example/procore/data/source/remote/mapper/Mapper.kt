package com.example.procore.data.source.remote.mapper

import com.example.procore.data.source.remote.model.PokemonDto
import com.example.procore.domin.model.Pokemon

/**
 * Created by Aziza Helmy on 25/06/2025.
 */

fun PokemonDto.toEntity(): List<Pokemon> {

    return data?.map { Pokemon(image = it.images?.small.orEmpty()) }.orEmpty()
}
