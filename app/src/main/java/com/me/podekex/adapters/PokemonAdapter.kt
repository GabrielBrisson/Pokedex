package com.me.podekex.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.me.podekex.data.remote.responses.Result
import com.me.podekex.databinding.ItemPokemonBinding
import com.squareup.picasso.Picasso

class PokemonAdapter() : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private val pokemonList = ArrayList<Result>()

    inner class ViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item_pokemon: Result) {
            binding.pokemonItemName.text = item_pokemon.name
            Picasso.get()
                .load(item_pokemon.url)
                .resize(200, 180)
                .centerCrop()
                .into(binding.pokemonItemImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    fun setValue(value: List<Result>){
       pokemonList.addAll(value)
    }
}