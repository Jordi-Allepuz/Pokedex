package com.example.pokedex.pokedexapp.ui.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.pokedexapp.data.dataInfo.Pokemon
import com.example.pokedex.pokedexapp.domain.usecases.GetPokemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val getPokemonUseCase: GetPokemoUseCase):
    ViewModel(){

    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> = _pokemon

    init {
        loadPokemon("squirtle.json")
    }

    private fun loadPokemon(jsonNombre: String) {
        viewModelScope.launch {
            _pokemon.value = getPokemonUseCase.execute(jsonNombre)
        }
    }

}