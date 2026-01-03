package br.com.ktor

import br.com.ktor.model.CurrencyTypeResultResponse
import br.com.ktor.model.ExchangeRateResponse
import br.com.ktor.model.commonCurrencies
import br.com.ktor.model.commonExchangeRates
import br.com.ktor.model.orUnknown
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {

        // rota base
        route("/currency") {

            // tipos de moedas (nome, acrônimo, símbolo, bandeira)
            get("/currency-types/v1/metadata") {
                call.respond(
                    CurrencyTypeResultResponse(
                        values = commonCurrencies
                    )
                )
            }

            // taxa de conversão entre moedas
            get("/exchange-rate/{from}/{to}") {

                val from = call.parameters["from"]?.uppercase()
                    ?: return@get call.respondText(
                        text = "Não foi possível obter o acrônimo da moeda atual.",
                        status = HttpStatusCode.BadRequest
                    )

                val to = call.parameters["to"]?.uppercase()
                    ?: return@get call.respondText(
                        text = "Não foi possível obter o acrônimo da moeda alvo.",
                        status = HttpStatusCode.BadRequest
                    )

                call.respond(
                    ExchangeRateResponse(
                        from = from.orUnknown(),
                        to = to.orUnknown(),
                        exchangeRate = commonExchangeRates[from]?.get(to) ?: 0.0
                    )
                )
            }
        }
    }
}
