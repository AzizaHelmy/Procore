package com.example.procore.presention.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.procore.domin.PokemonRepository
import com.example.procore.domin.entity.Pokemon
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 15/07/2025.
 */
class PokemonPagingSource @Inject constructor(val repo: PokemonRepository) : PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val pageNo = params.key ?: 1
        try {
            val result = repo.getAllPokemons(pageNo)

            return LoadResult.Page(
                data = result,
                prevKey = if (pageNo == 1) null else pageNo - 1,
                nextKey = pageNo + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }


}