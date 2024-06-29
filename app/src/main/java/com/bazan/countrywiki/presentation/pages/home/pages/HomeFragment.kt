package com.bazan.countrywiki.presentation.pages.home.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bazan.countrywiki.R
import com.bazan.countrywiki.databinding.FragmentHomeBinding
import com.bazan.countrywiki.presentation.pages.home.adapters.CountriesListAdapter
import com.bazan.countrywiki.presentation.pages.home.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        initCountryList()
        homeViewModel.getAllCountries()
        return binding.root
    }

    private fun initCountryList() {
        homeViewModel.countryList.observe(requireActivity()) { countries ->
            if (countries != null) {
                val recyclerView =
                    binding.root.findViewById<RecyclerView>(R.id.recyclerViewQuestionsReminders)

                recyclerView.layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL, false
                )

                recyclerView.adapter = CountriesListAdapter(countries, onClick = {
                    val action = HomeFragmentDirections.actionHomeFragmentToDetailScreenFragment(name = it)
                    findNavController().navigate(action)
                })
            }
        }
    }
}