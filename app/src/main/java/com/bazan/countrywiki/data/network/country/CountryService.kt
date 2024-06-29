package com.bazan.countrywiki.data.network.country

import android.util.Log
import com.bazan.countrywiki.domain.exceptions.NoConnectivityException
import com.bazan.countrywiki.domain.models.Country
import com.bazan.countrywiki.domain.models.CountryDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class CountryService @Inject constructor(
    private val api: CountryApiClient
) {

    suspend fun getAllCountries(): List<Country>? {
        return withContext(Dispatchers.IO) {
            try {
                api.getAllCountries().body()
            } catch (e: NoConnectivityException) {
                Log.e("COUNTRY SERVICE", e.message)
                return@withContext emptyList<Country>()
            }
        }
    }

    suspend fun getCountry(name: String): List<CountryDetails>? {
        return withContext(Dispatchers.IO) {
            try {
                api.getCountry(name).body()
            } catch (e: NoConnectivityException) {
                Log.e("COUNTRY SERVICE", e.message)
                return@withContext emptyList<CountryDetails>()
            } catch (e: Exception) {
                Log.e("COUNTRY SERVICE", e.message.toString())
                return@withContext emptyList<CountryDetails>()
            }
        }
    }
}