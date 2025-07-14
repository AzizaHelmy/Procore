package com.example.procore.data.repostiory

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.procore.data.repostiory.paging.PokemonPagingSource
import com.example.procore.data.source.remote.network.PokemonApiService
import com.example.procore.domin.PokemonRepository
import com.example.procore.domin.entity.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
class PokemonRepositoryImp @Inject constructor(val pokemonApiService: PokemonApiService) :
    PokemonRepository {


    override fun getAllPokemons(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(pageSize = 50),
            initialKey = null,
            pagingSourceFactory = {
                PokemonPagingSource(
                    pokemonApiService
                )
            }).flow
    }
}