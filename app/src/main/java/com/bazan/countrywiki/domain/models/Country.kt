package com.bazan.countrywiki.domain.models

import com.google.gson.annotations.SerializedName

data class Country(
    val flags: Flags,
    val name: Name
)

data class Flags (
    val png: String,
    val svg: String,
    val alt: String
)

data class Name (
    val common: String,
    val official: String,
    val nativeName: NativeName
)

data class NativeName (
    val fra: Fra
)

data class Fra (
    val official: String,
    val common: String
)
