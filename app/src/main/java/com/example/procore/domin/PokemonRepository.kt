package com.example.procore.domin

import androidx.paging.PagingData
import com.example.procore.domin.entity.Pokemon
import kotlinx.coroutines.flow.Flow

/**
 * Created by Aziza Helmy on 25/06/2025.
 */

fun interface PokemonRepository {
     fun getAllPokemons(): Flow<PagingData<Pokemon>>

}