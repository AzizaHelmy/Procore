package com.example.procore.presention.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.procore.domin.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
@HiltViewModel
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
                _state.update { it.copy(pokemons = result.toUiState(), isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message.orEmpty()) }
            }
        }
    }
}