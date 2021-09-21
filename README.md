# android-code-challenge

This project implements a scrollable list of posts.
For each post, it shows the author name, post title, the post body and the author image

## Features
* MVVM
* Kotlin Coroutines with Flow (State Flow)
* Dagger Hilt
* Light/Dark Mode Support
* Jetpack Compose 


## Prerequisite
To build this project, you require:
- Android Studio arctic fox
- Gradle 7.0.0+


## Libraries

- [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - ViewModel for persisting view state across config changes
- [Retrofit](https://square.github.io/retrofit/) - type safe http client and supports coroutines out of the box.
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - logs HTTP request and response data.
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines,provides `runBlocking` coroutine builder used in tests
- [Dagger Hilt](https://dagger.dev/hilt) - handles dependency injection
- [Truth](https://github.com/google/truth) - handles testing
- [Coil](https://github.com/coil-kt/coil) - For Asynchronously fetching data
- [Moshi](https://github.com/square/moshi)

## Author
Andy Eshiet

## License
This project is licensed under the Apache License 2.0 - See: http://www.apache.org/licenses/LICENSE-2.0.txt