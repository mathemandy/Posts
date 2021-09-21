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
- Android Studio arctic 
- Gradle 7.0.0+
- you may be required to use Java-11 to build the project.  See Screenshots below


## Design
A Simple Design was provided and it was easy to follow. The Choice of Jepack was because of the speed and easy-ness to create simple and amazing UIs.

Seeing that the app would basically have three states, i decided to use MVVM with a StateFlow to manage the states of the UI. 

## Architecture
I have decided to break down the apps by features, which will be very easy to follow and maintain. 
A Repository pattern is used here to fetch data from a Network which is provided by Retrofit. 

## Testing
Testing is done with Junit4 testing framework, and with Google Truth for making assertions. The test uses fake objects for all tests instead of mocks, making it easier to verify interactions between objects and their dependencies, and simulate the behavior of the real objects.

The test can do with UI tests that verify that the view state is rendered as expected. However, the extensive unit test coverage ensures that the app works as expected.

## Extras 
The project uses ktlint and Detekt to enforce proper code style. Also a pre-push githook has been added to ensure that this checks are done before pushing to the server.

## Building issue that may arise.


