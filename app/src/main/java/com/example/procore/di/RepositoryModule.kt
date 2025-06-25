package com.example.procore.di

import com.example.procore.data.repostiory.PokemonRepositoryImp
import com.example.procore.domin.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Aziza Helmy on 25/06/2025.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindPokemonRepo(pokemonRepositoryImp: PokemonRepositoryImp): PokemonRepository

}