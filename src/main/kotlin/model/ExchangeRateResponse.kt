package br.com.ktor.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRateResponse (
    val from: String,
    val to: String,
    @SerialName("exchange_rate")
    val exchangeRate: Double
)

val commonExchangeRates: Map<String, Map<String, Double>> = mapOf(
    "BRL" to mapOf(
        "USD" to 1 / 5.35,     // ≈ 0,1869
        "EUR" to (1 / 5.35) * 0.93, // supondo 1 EUR ≈ 1,07 USD → 0,173 (apenas exemplo)
        "GBP" to (1 / 5.35) * 0.80, // exemplo
        "JPY" to (1 / 5.35) * 177.0, // ≈ 33,07
        "CHF" to (1 / 5.35) * 0.92,
        "CAD" to (1 / 5.35) * 1.35,
        "AUD" to (1 / 5.35) * 1.50,
        "CNY" to (1 / 5.35) * 7.20,
        "INR" to (1 / 5.35) * 83.0
    ),
    "USD" to mapOf(
        "BRL" to 5.35,
        "EUR" to 0.93,
        "GBP" to 0.80,
        "JPY" to 177.0,
        "CHF" to 0.92,
        "CAD" to 1.35,
        "AUD" to 1.50,
        "CNY" to 7.20,
        "INR" to 83.0
    ),
    "EUR" to mapOf(
        "USD" to 1.075,      // exemplo: 1 EUR = 1,075 USD
        "BRL" to 5.35 * 1.075, // ≈ 5,75
        "GBP" to 0.86,
        "JPY" to 177.0,
        "CHF" to 0.99,
        "CAD" to 1.45,
        "AUD" to 1.60,
        "CNY" to 7.80,
        "INR" to 90.0
    ),
    // você faria o mesmo para “GBP”, “JPY”, “CHF”, “CAD”, “AUD”, “CNY”, “INR”
    "JPY" to mapOf(
        "USD" to 1.0 / 177.0,
        "BRL" to (1.0 / 177.0) * 5.35,
        "EUR" to 1.0 / 177.0 * 1.075,
        "GBP" to 0.86 / 177.0,
        "CHF" to 0.99 / 177.0,
        "CAD" to 1.45 / 177.0,
        "AUD" to 1.60 / 177.0,
        "CNY" to 7.80 / 177.0,
        "INR" to 90.0 / 177.0
    ),
    "GBP" to mapOf(
        "USD" to 1.25,
        "BRL" to 5.35 * 1.25,
        "EUR" to 1.16,
        "JPY" to 177.0 * (1.25 / 0.93),
        "CHF" to 1.15,
        "CAD" to 1.70,
        "AUD" to 1.90,
        "CNY" to 9.0,
        "INR" to 100.0
    ),
    "CHF" to mapOf(
        "USD" to 1.09,
        "BRL" to 5.35 * 1.09,
        "EUR" to 1.01,
        "JPY" to 177.0 * (1.09 / 0.93),
        "GBP" to 0.87,
        "CAD" to 1.50,
        "AUD" to 1.70,
        "CNY" to 8.50,
        "INR" to 95.0
    ),
    "CAD" to mapOf(
        "USD" to 0.74,
        "BRL" to 5.35 * 0.74,
        "EUR" to 0.69,
        "JPY" to 177.0 * (0.74 / 0.93),
        "GBP" to 0.59,
        "CHF" to 0.67,
        "AUD" to 1.15,
        "CNY" to 5.6,
        "INR" to 62.0
    ),
    "AUD" to mapOf(
        "USD" to 0.67,
        "BRL" to 5.35 * 0.67,
        "EUR" to 0.62,
        "JPY" to 177.0 * (0.67 / 0.93),
        "GBP" to 0.53,
        "CHF" to 0.59,
        "CAD" to 0.87,
        "CNY" to 4.8,
        "INR" to 54.0
    ),
    "CNY" to mapOf(
        "USD" to 0.14,
        "BRL" to 5.35 * 0.14,
        "EUR" to 0.13,
        "JPY" to 177.0 * (0.14 / 0.93),
        "GBP" to 0.11,
        "CHF" to 0.12,
        "CAD" to 0.18,
        "AUD" to 0.21,
        "INR" to 7.8
    ),
    "INR" to mapOf(
        "USD" to 0.012,
        "BRL" to 5.35 * 0.012,
        "EUR" to 0.011,
        "JPY" to 177.0 * (0.012 / 0.93),
        "GBP" to 0.009,
        "CHF" to 0.010,
        "CAD" to 0.016,
        "AUD" to 0.018,
        "CNY" to 0.13
    )
)

// val usdEur = commonExchangeRates["USD"]?.get("EUR") ?: //...
