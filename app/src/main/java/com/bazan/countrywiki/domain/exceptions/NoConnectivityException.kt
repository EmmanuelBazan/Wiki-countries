package com.bazan.countrywiki.domain.exceptions

import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String
        get() = "No Internet Connection"
}