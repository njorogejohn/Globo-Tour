package com.njoro.globotour.favourite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.njoro.globotour.city.City
import com.njoro.globotour.databinding.ListItemFavoriteBinding

class FavoriteAdapter(val context: Context, var favoriteCities: ArrayList<City>):
    RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
       val listItemFavoriteBinding = ListItemFavoriteBinding.inflate(LayoutInflater.from(context),parent, false)
        return FavoriteViewHolder(listItemFavoriteBinding.root)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favoriteCity = favoriteCities[position]
        holder.setData(favoriteCity, position)
    }

    override fun getItemCount(): Int = favoriteCities.size

    inner class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding = ListItemFavoriteBinding.bind(itemView)

        fun setData(favoriteCity: City, position: Int) {
            binding.txvFavoriteName.text = favoriteCity.name
            binding.imvCityFavorite.setImageResource(favoriteCity.imageId)
        }

    }
}