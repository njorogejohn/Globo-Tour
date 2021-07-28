package com.njoro.globotour.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.njoro.globotour.city.City
import com.njoro.globotour.city.VacationSpots
import com.njoro.globotour.databinding.FragmentFavouriteBinding
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class FavouriteFragment : Fragment() {

    private lateinit var favoriteCities: ArrayList<City>
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var favoriteRecyclerView: RecyclerView

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
        favoriteCities = VacationSpots.favourableCities as ArrayList<City>
        favoriteAdapter = FavoriteAdapter(context,
            favoriteCities
        )

        val binding = FragmentFavouriteBinding.bind(view)

        favoriteRecyclerView = binding.favoriteRecyclerView
        favoriteRecyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        favoriteRecyclerView.layoutManager = layoutManager

        favoriteRecyclerView.adapter = favoriteAdapter

        itemTouchHelper.attachToRecyclerView(favoriteRecyclerView)
    }

    private val itemTouchHelper = ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN,0){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            targetViewHolder: RecyclerView.ViewHolder
        ): Boolean {
            val fromPosition = viewHolder.adapterPosition
            val toPosition = targetViewHolder.adapterPosition

            Collections.swap(favoriteCities, fromPosition, toPosition)

            favoriteRecyclerView.adapter?.notifyItemMoved(fromPosition, toPosition)
            return true

        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            TODO("Not yet implemented")
        }

    })

}