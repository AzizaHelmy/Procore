package com.example.procore.presention.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.procore.domin.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(val repo: PokemonRepository) : ViewModel() {

    val pokemons: Flow<PagingData<PokemonUiState>> =
        repo.getAllPokemons().map { it.map { it.toUiState() } }.cachedIn(viewModelScope)
}