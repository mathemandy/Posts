package life.league.challenge.kotlin.features.auth.remote.impl

import life.league.challenge.kotlin.features.auth.contract.LoginRemote
import life.league.challenge.kotlin.features.auth.remote.LoginApiService
import life.league.challenge.kotlin.model.Account
import javax.inject.Inject

class LoginRemoteImpl @Inject constructor(private val loginApiService: LoginApiService) : LoginRemote {
    override suspend fun login(): Account {
        return loginApiService.login("Basic " + android.util.Base64.encodeToString("andy:best".toByteArray(), android.util.Base64.NO_WRAP))
    }
}
