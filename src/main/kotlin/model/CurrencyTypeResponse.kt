package br.com.ktor.model

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyTypeResponse (
    val name: String,
    val acronym: String,
    val symbol: String,
    val countryFlagImageUrl: String
)

@Serializable
data class CurrencyTypeResultResponse (
    val values: List<CurrencyTypeResponse>
)

val commonCurrencies = listOf(
    CurrencyTypeResponse(
        name = "Real Brasileiro",
        acronym = "BRL",
        symbol = "R$",
        countryFlagImageUrl = "https://flagcdn.com/w320/br.png"
    ),
    CurrencyTypeResponse(
        name = "Dólar Americano",
        acronym = "USD",
        symbol = "$",
        countryFlagImageUrl = "https://flagcdn.com/w320/us.png"
    ),
    CurrencyTypeResponse(
        name = "Euro",
        acronym = "EUR",
        symbol = "€",
        countryFlagImageUrl = "https://flagcdn.com/w320/eu.png"
    ),
    CurrencyTypeResponse(
        name = "Libra Esterlina",
        acronym = "GBP",
        symbol = "£",
        countryFlagImageUrl = "https://flagcdn.com/w320/gb.png"
    ),
    CurrencyTypeResponse(
        name = "Iene Japonês",
        acronym = "JPY",
        symbol = "¥",
        countryFlagImageUrl = "https://flagcdn.com/w320/jp.png"
    ),
    CurrencyTypeResponse(
        name = "Yuan Chinês (Renminbi)",
        acronym = "CNY",
        symbol = "¥",
        countryFlagImageUrl = "https://flagcdn.com/w320/cn.png"
    )
)