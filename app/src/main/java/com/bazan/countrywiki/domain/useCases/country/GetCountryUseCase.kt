package com.bazan.countrywiki.domain.useCases.country

import com.bazan.countrywiki.data.repositories.CountryRepository
import com.bazan.countrywiki.domain.models.CountryDetails
import javax.inject.Inject

class GetCountryUseCase  @Inject constructor(
    private val repository: CountryRepository
) {
    suspend operator fun invoke(name: String): List<CountryDetails>? {
        return repository.getCountry(name)
    }
}