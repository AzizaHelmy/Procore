package com.example.procore.data.repostiory.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.procore.data.source.remote.mapper.toEntity
import com.example.procore.data.source.remote.network.PokemonApiService
import com.example.procore.domin.entity.Pokemon
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 14/07/2025.
 */

class PokemonPagingSource @Inject constructor(val pokemonApiService: PokemonApiService) :
    PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val pageNo = params.key ?: 1
        try {
            val response = pokemonApiService.getPokemons(pageNo)

            return LoadResult.Page(
                data = response.body()?.toEntity().orEmpty(),
                prevKey = if (pageNo == 1) null else pageNo - 1,
                nextKey = pageNo
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition
    }

}