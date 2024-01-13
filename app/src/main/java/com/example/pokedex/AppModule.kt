package com.example.pokedex

import android.app.Application
import android.content.Context
import com.example.pokedex.pokedexapp.data.repositories.PokemonRepositoryImpl
import com.example.pokedex.pokedexapp.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.pokedexapp.domain.repositories.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{


    @Provides
    @Singleton
    fun providePokemonRepository(dataSource: PokemonLocalDataSource): PokemonRepositoryImpl {
        return PokemonRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideApplicationContext(app: Application): Context = app
}