package com.me.podekex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.me.podekex.adapters.PokemonAdapter
import com.me.podekex.databinding.ActivityMainBinding
import com.me.podekex.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.getPokemonList()
        viewModel.pokemonList.observe(this){
            when(it){
                is Resource.Loading -> {}
                is Resource.Error -> {}
                is Resource.Success -> {
                    binding.recycler.layoutManager = GridLayoutManager(this, 2)
                    binding.recycler.adapter = PokemonAdapter().apply {
                        it.data?.results?.let { it1 -> setValue(it1) }
                    }
                }
            }
        }

    }
}