package com.bazan.countrywiki.presentation.pages.detail.pages

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.bazan.countrywiki.R
import com.bazan.countrywiki.databinding.FragmentDetailScreenBinding
import com.bazan.countrywiki.databinding.FragmentHomeBinding
import com.bazan.countrywiki.presentation.pages.detail.viewModel.DetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailScreenFragment : Fragment() {
    private var _binding: FragmentDetailScreenBinding? = null
    private val binding get() = _binding!!

    private val args: DetailScreenFragmentArgs by navArgs()

    private val detailViewModel: DetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailScreenBinding.inflate(inflater,container,false)
        initObserver()
        detailViewModel.getCountry(args.name)
        return binding.root
    }

    private fun initObserver() {
        detailViewModel.countryList.observe(requireActivity()) {countries ->
            if (!countries.isNullOrEmpty()) {
                binding.detailCommonName.text = "Nombre comun: ${countries[0].name.common}"
                binding.detailOficialName.text = "Nombre oficial: ${countries[0].name.official}"
                binding.detailCapital.text = "Capital: ${countries[0].capital[0]}"
                binding.detailContinente.text = "Continente: ${countries[0].continents[0]}"
                binding.detailDescBandera.text = "Bandera: ${countries[0].flag}"

                Picasso.get()
                    .load(countries[0].coatOfArms.png)
                    .into(binding.imgEscudo)

                binding.btnMap.setOnClickListener {
                    val browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(countries[0].maps.googleMaps)
                    )
                    startActivity(browserIntent)
                }
            }
        }
    }
}