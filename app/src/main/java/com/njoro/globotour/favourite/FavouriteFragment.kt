package com.njoro.globotour.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.njoro.globotour.city.City
import com.njoro.globotour.city.VacationSpots
import com.njoro.globotour.databinding.FragmentFavouriteBinding


/**
 * A simple [Fragment] subclass.
 */
class FavouriteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view =  FragmentFavouriteBinding.inflate(
                inflater,container,false).root//inflater.inflate(R.layout.fragment_favourite, container, false)

        setupRecyclerView(view)

        return view
    }

    private fun setupRecyclerView(view: View) {
        val context = requireContext()
        val favoriteAdapter = FavoriteAdapter(context,
            VacationSpots.favourableCities as ArrayList<City>
        )

        val binding = FragmentFavouriteBinding.bind(view)

        binding.favoriteRecyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.favoriteRecyclerView.layoutManager = layoutManager

        binding.favoriteRecyclerView.adapter = favoriteAdapter
    }

}