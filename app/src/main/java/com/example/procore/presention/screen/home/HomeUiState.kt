package com.example.procore.presention.screen.home

import com.example.procore.domin.entity.Pokemon

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
data class HomeUiState(
    val pokemons: List<PokemonUiState> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String = ""
)

data class PokemonUiState(val image: String)


fun List<Pokemon>.toUiState() = this.map {
    PokemonUiState(image = it.image)
}