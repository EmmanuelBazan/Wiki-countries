package com.bazan.countrywiki.domain.useCases.country

import com.bazan.countrywiki.data.repositories.CountryRepository
import com.bazan.countrywiki.domain.models.Country
import javax.inject.Inject

class GetAllCountriesUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    suspend operator fun invoke(): List<Country>? {
        return repository.getAllCountries()
    }
}