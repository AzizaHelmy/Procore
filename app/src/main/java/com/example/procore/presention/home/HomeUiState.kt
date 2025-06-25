package com.example.procore.presention.home

import com.example.procore.domin.model.Pokemon

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
data class HomeUiState(
    val images: List<PokemonUiState> = emptyList(),
    val isLoading: Boolean = true,
    val error: String = ""

)


data class PokemonUiState(val image: String)


fun List<Pokemon>.toUiState = this.map {

}