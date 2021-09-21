package life.league.challenge.kotlin

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import dagger.hilt.android.AndroidEntryPoint
import life.league.challenge.kotlin.ui.App
import life.league.challenge.kotlin.ui.theme.LeagueAppTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeagueAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    App()
                }
            }
        }
    }
}
