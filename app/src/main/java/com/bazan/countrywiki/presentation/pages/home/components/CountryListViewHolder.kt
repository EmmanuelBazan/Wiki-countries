package com.bazan.countrywiki.presentation.pages.home.components

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bazan.countrywiki.R
import com.bazan.countrywiki.domain.models.Country
import com.squareup.picasso.Picasso

class CountryListViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val txtCommonName: TextView = view.findViewById(R.id.commonName)
    private val txtOfficialName: TextView = view.findViewById(R.id.officialName)
    private val imgFlag = view.findViewById<ImageView>(R.id.imgFlag)

    fun render(country: Country,onClick: (name:String) -> Unit) {
        txtCommonName.text = country.name.common
        txtOfficialName.text = country.name.official

        Picasso.get()
            .load(country.flags.png)
            .into(imgFlag)

        view.setOnClickListener{
            onClick(country.name.common)
        }
    }
}