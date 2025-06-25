package com.example.procore.di

import com.example.procore.data.source.remote.network.PokemonApiService
import com.example.procore.data.source.remote.network.PokemonRetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Aziza Helmy on 25/06/2025.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(apiService: PokemonApiService) = PokemonRetrofitClient.create()
}