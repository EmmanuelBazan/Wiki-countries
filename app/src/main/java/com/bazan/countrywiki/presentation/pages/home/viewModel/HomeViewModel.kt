package com.bazan.countrywiki.presentation.pages.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bazan.countrywiki.domain.models.Country
import com.bazan.countrywiki.domain.useCases.country.GetAllCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase,
) : ViewModel() {
    val countryList = MutableLiveData<List<Country>?>(emptyList())
    val loading = MutableLiveData<Boolean>()

    fun getAllCountries(
    ) {
        viewModelScope.launch {
            loading.postValue(true)
            val list = getAllCountriesUseCase()
            if (list != null) {
                countryList.postValue(list)
            }
            loading.postValue(false)
        }
    }
}