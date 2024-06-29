package com.bazan.countrywiki.presentation.pages.detail.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bazan.countrywiki.domain.models.Country
import com.bazan.countrywiki.domain.models.CountryDetails
import com.bazan.countrywiki.domain.useCases.country.GetAllCountriesUseCase
import com.bazan.countrywiki.domain.useCases.country.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel  @Inject constructor(
    private val getCountryUseCase: GetCountryUseCase,
) : ViewModel() {
    val countryList = MutableLiveData<List<CountryDetails>?>(emptyList())
    val loading = MutableLiveData<Boolean>()

    fun getCountry(
        name: String
    ) {
        viewModelScope.launch {
            loading.postValue(true)
            val list = getCountryUseCase(name)
            if (list != null) {
                countryList.postValue(list)
            }
            loading.postValue(false)
        }
    }
}