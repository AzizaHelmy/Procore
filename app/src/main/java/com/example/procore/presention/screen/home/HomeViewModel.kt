package com.example.procore.presention.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.procore.domin.PokemonRepository
import com.example.procore.presention.paging.PokemonPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    //val repo: PokemonRepository,
    val pagingSource: PokemonPagingSource
) : ViewModel() {

//    private val _state = MutableStateFlow(HomeUiState())
//    val state = _state.asStateFlow()

    val pokemons: Flow<PagingData<PokemonUiState>> = Pager(
        config = PagingConfig(
            pageSize = 50,
            enablePlaceholders = false,
            initialLoadSize = 50,
            prefetchDistance = 10
        ),
        pagingSourceFactory = { pagingSource }).flow
        .cachedIn(viewModelScope)
        .map { it.map { it.toUiState() } }

    /*  init {
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
      }*/
}