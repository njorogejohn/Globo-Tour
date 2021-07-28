package com.njoro.globotour.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.njoro.globotour.databinding.FragmentCityBinding


/**
 * A simple [Fragment] subclass.
 *
 */
class CityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = FragmentCityBinding.inflate(
            inflater,
            container,
            false

        ).root //inflater.inflate(R.layout.fragment_city, container, false)
        setupRecyclerView(view)
        return  view;
    }

    private fun setupRecyclerView(view: View) {
        val context = requireContext()
        val cityAdapter = CityAdapter(context, VacationSpots.cityList!!)

        view.let {
            val binding = FragmentCityBinding.bind(it)

            binding.cityRecyclerView.setHasFixedSize(true)

            val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
            binding.cityRecyclerView.layoutManager = layoutManager


            binding.cityRecyclerView.adapter = cityAdapter


        }


    }

}