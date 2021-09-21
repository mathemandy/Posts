package life.league.challenge.kotlin.model

import com.squareup.moshi.Json

data class Account(@Json(name = "api_key") val apiKey: String? = null)
