package com.bazan.countrywiki.data.repositories

import com.bazan.countrywiki.data.network.country.CountryService
import com.bazan.countrywiki.domain.models.Country
import com.bazan.countrywiki.domain.models.CountryDetails
import javax.inject.Inject

class CountryRepository  @Inject constructor(
    private val api: CountryService
) {
    suspend fun getAllCountries(): List<Country>? {
        return api.getAllCountries()
    }

    suspend fun getCountry(name: String): List<CountryDetails>? {
        return api.getCountry(name)
    }
}