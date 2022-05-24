package com.me.podekex

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.me.podekex.data.remote.responses.PokemonList
import com.me.podekex.repository.PokemonRepository
import com.me.podekex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: PokemonRepository) : ViewModel() {

    val pokemonList = MutableLiveData<Resource<PokemonList>>()

    fun getPokemonList() {
        viewModelScope.launch {
            pokemonList.value = repository.getPokemonList(20, 0)
        }
    }
}