package life.league.challenge.kotlin.features.users.remote.impl

import life.league.challenge.kotlin.features.users.contract.GetUserByIdRemote
import life.league.challenge.kotlin.features.users.remote.UserApiService
import life.league.challenge.kotlin.model.User
import javax.inject.Inject

internal class GetUserByIdRemoteImpl @Inject constructor(
    private val apiService: UserApiService
) : GetUserByIdRemote{
    override suspend fun getUserById(key: String?): List<User> {
        return apiService.getUserById(key)
    }
}