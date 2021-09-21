package life.league.challenge.kotlin.features.users.contract

import life.league.challenge.kotlin.model.User

interface GetUsersRemote {
    suspend fun getUsers(key: String? = null): List<User>
}
