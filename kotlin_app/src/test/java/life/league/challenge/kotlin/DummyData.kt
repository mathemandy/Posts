package life.league.challenge.kotlin

import life.league.challenge.kotlin.model.Account
import life.league.challenge.kotlin.model.Avatar
import life.league.challenge.kotlin.model.Post
import life.league.challenge.kotlin.model.User

object DummyData {

    val users = MutableList(4) {
        User(
            avatar = Avatar(
                "http://large",
                "http://medium",
                "http://thumbnail"
            ),
            "Andy Eshiet",
            it
        )
    }

    val posts = MutableList(4) {
        Post(
            imageUrl =
                "http://medium",
            author = "Andy Eshiet",
            id = it,
            title = "A Great title",
            body = "Warmer Body",
            userId = 1
        )
    }

    val apiKey = Account(apiKey = "xudjdkdodjd")
}
