package com.example.procore.presention.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.procore.domin.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 25/06/2025.
 */

class HomeViewModel @Inject constructor(val repo: PokemonRepository) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()


    init {
        getAllPokemons()
    }

    private fun getAllPokemons() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val result = repo.getAllPokemons()
                _state.update { it.copy(images = result) }
            }
        }

    }

}