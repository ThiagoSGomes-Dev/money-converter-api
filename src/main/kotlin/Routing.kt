package br.com.ktor

import br.com.ktor.model.CurrencyTypeResultResponse
import br.com.ktor.model.ExchangeRateResponse
import br.com.ktor.model.commonCurrencies
import br.com.ktor.model.commonExchangeRates
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import br.com.ktor.model.orUnknown

fun Application.configureRouting() {
    routing {
        // tipos de moedas (nome, acroimo, símbolo, imagem da bandeira do país)
        get("/currency-types/v1/metadata") {
            call.respond(
                CurrencyTypeResultResponse(
                    values = commonCurrencies
                )
            )
        }

        // conversão de valores, moeda atual, taxa de conversão entre essas moedas
        get("/exchange-rate/{from}/{to}") {
            val from = call.parameters["from"]?.uppercase() ?: return@get call.respondText (
                status = HttpStatusCode.BadRequest,
                text = "Não foi possível obter o acrônimo da moeda atual."
            )
            val to = call.parameters["to"]?.uppercase() ?: return@get call.respondText (
                status = HttpStatusCode.BadRequest,
                text = "Não foi possível obter o acrônimo da moeda alvo."
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
