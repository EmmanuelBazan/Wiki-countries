package com.bazan.countrywiki.domain.models

import com.google.gson.annotations.SerializedName

data class CountryDetails(
    val name: Name,
    val tld: List<String>,
    val cca2: String,
    val ccn3: String,
    val cca3: String,
    val cioc: String,
    val independent: Boolean,
    val status: String,
    val unMember: Boolean,
    val currencies: Currencies,
    val idd: Idd,
    val capital: List<String>,
    val altSpellings: List<String>,
    val region: String,
    val subregion: String,
    val languages: Languages,
    val translations: Map<String, Translation>,
    val latlng: List<Double>,
    val landlocked: Boolean,
    val borders: List<String>,
    val area: Long,
    val demonyms: Demonyms,
    val flag: String,
    val maps: Maps,
    val population: Long,
    val gini: Gini,
    val fifa: String,
    val car: Car,
    val timezones: List<String>,
    val continents: List<String>,
    val flags: Flags,
    val coatOfArms: CoatOfArms,
    val startOfWeek: String,
    val capitalInfo: CapitalInfo,
    val postalCode: PostalCode
)

data class CapitalInfo (
    val latlng: List<Double>
)

data class Car (
    val signs: List<String>,
    val side: String
)

data class CoatOfArms (
    val png: String,
    val svg: String
)

data class Currencies (
    @SerializedName("MDL")
    val mdl: Mdl
)

data class Mdl (
    val name: String,
    val symbol: String
)

data class Demonyms (
    val eng: Eng,
    val fra: Eng
)

data class Eng (
    val f: String,
    val m: String
)

data class Gini (
    @SerializedName("2018")
    val the2018: Double
)

data class Idd (
    val root: String,
    val suffixes: List<String>
)

data class Languages (
    val ron: String
)

data class Maps (
    val googleMaps: String,
    val openStreetMaps: String
)

data class Translation (
    val official: String,
    val common: String
)

data class PostalCode (
    val format: String,
    val regex: String
)
