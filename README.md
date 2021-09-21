# android-code-challenge

This project implements a scrollable list of posts.
For each post, it shows the author name, post title, the post body and the author image

See [Process.md]() for walkthrough

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

## Screenshots
<h2 align="left">Screenshots</h2>
<h4 align="center">
<img src="https://user-images.githubusercontent.com/6526607/134254829-e41eae80-67f8-471b-874f-bb807c2d871d.jpg" width="30%" vspace="10" hspace="10">
<img src="https://user-images.githubusercontent.com/6526607/134254836-2be2d7b4-9e3c-4554-92f9-92eb87896b79.jpg" width="30%" vspace="10" hspace="10"><br>
  

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
