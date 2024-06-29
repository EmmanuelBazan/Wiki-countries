package com.bazan.countrywiki.presentation.pages.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bazan.countrywiki.R
import com.bazan.countrywiki.domain.models.Country
import com.bazan.countrywiki.presentation.pages.home.components.CountryListViewHolder

class CountriesListAdapter(
    private val countryList: List<Country>,
    private val onClick: (name: String) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return CountryListViewHolder(
            layoutInflater.inflate(
                R.layout.item_country_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = countryList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            when (holder) {
                is CountryListViewHolder -> {
                    val item = countryList[position]
                    holder.render(item,onClick)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}