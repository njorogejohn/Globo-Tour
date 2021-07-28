package com.njoro.globotour.city

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.njoro.globotour.R
import com.njoro.globotour.city.CityAdapter.CityViewHolder
import com.njoro.globotour.databinding.ListItemCityBinding

class CityAdapter(val context: Context, var cityList: ArrayList<City>): Adapter<CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val listItemCityBinding = ListItemCityBinding.inflate(LayoutInflater.from(context), parent, false)
        return CityViewHolder(listItemCityBinding.root)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cityList[position]
        holder.setData(city, position)
    }

    override fun getItemCount(): Int = cityList.size


    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var currentPosition: Int = -1
        private var currentCity: City? = null
        private var binding =  ListItemCityBinding.bind(itemView)
        private val icFavouriteFilledImage = ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.ic_favorite_filled,
            null)
        private val icFavouriteBorderedImage = ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.ic_favorite_bordered,
            null)

        fun setData(city: City, position: Int) {
            binding.txvCityName.text = city.name
            binding.imvCity.setImageResource(city.imageId)

            if (city.isFavorite) {
                binding.imvFavorite.setImageDrawable(icFavouriteFilledImage)
            }else {
                binding.imvFavorite.setImageDrawable(icFavouriteBorderedImage)
            }

            this.currentCity = city
            this.currentPosition = position
        }
    }

}