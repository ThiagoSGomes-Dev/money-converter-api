package br.com.ktor.model

fun String.orUnknown() : String =
    if (this in commonExchangeRates.keys) this else "Desconhecido"