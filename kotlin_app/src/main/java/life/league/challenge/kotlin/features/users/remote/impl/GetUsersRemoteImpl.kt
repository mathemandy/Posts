package life.league.challenge.kotlin.features.users.remote.impl

import life.league.challenge.kotlin.features.users.contract.GetUsersRemote
import life.league.challenge.kotlin.features.users.remote.UserApiService
import life.league.challenge.kotlin.model.User
import javax.inject.Inject

internal class GetUsersRemoteImpl @Inject constructor(
    private val apiService: UserApiService
) : GetUsersRemote {
    override suspend fun getUsers(key: String?): List<User> {
        return apiService.getUsers(key)
    }
}
