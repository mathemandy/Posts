package life.league.challenge.kotlin.model

data class User(
    val avatar: Avatar?,
    val name: String?,
    val id: Int?
)

data class Avatar(
    val large: String?,
    val medium: String?,
    val thumbnail: String?
)