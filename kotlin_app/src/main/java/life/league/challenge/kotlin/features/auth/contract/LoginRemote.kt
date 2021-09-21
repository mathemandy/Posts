package life.league.challenge.kotlin.features.auth.contract

import life.league.challenge.kotlin.model.Account

interface LoginRemote {
    suspend fun login(): Account
}
