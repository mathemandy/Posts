package life.league.challenge.kotlin.core.extension

val Throwable.errorMessage: String
    get() = message ?: localizedMessage ?: "An error occurred"
