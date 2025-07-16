package com.example.procore.presention.screen.home

import com.example.procore.domin.entity.Pokemon

/**
 * Created by Aziza Helmy on 25/06/2025.
 */

data class PokemonUiState(val image: String = "")


fun Pokemon.toUiState() =
    PokemonUiState(image = image)
