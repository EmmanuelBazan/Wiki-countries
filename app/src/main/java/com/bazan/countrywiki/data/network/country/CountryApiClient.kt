package com.bazan.countrywiki.data.network.country

import com.bazan.countrywiki.domain.models.Country
import com.bazan.countrywiki.domain.models.CountryDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountryApiClient {
    @GET("v3.1/all")
    suspend fun getAllCountries(
        @Query("fields") fields: String = "name,flags"
    ): Response<List<Country>>

    @GET("v3.1/name/{name}")
    suspend fun getCountry(
        @Path("name") name: String = ""
    ): Response<List<CountryDetails>>
}