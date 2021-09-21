package life.league.challenge.kotlin.features.users.contract

import life.league.challenge.kotlin.model.User

interface GetUserByIdRemote {
    suspend fun getUserById(key: String? = null): List<User>
}