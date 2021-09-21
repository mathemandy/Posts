package life.league.challenge.kotlin.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor() : ViewModel() {

    init {
        checkLogin()
    }

    private fun checkLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // val account = Service.api.login("hello", "world")
                // Log.v(TAG, account.apiKey ?: "")
            } catch (t: Throwable) {
                Log.e(TAG, t.message, t)
            }
        }
    }

    companion object {
        private const val TAG = "AppViewModel"
    }
}
