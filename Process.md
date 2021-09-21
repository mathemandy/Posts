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

## Screenshots
<h2 align="left">Screenshots</h2>
<h4 align="center">
<img src="https://user-images.githubusercontent.com/6526607/134254829-e41eae80-67f8-471b-874f-bb807c2d871d.jpg" width="30%" vspace="10" hspace="10">
<img src="https://user-images.githubusercontent.com/6526607/134254836-2be2d7b4-9e3c-4554-92f9-92eb87896b79.jpg" width="30%" vspace="10" hspace="10"><br>
  
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
  
  
  <img width="986" alt="Screenshot 2021-09-20 at 19 30 58" src="https://user-images.githubusercontent.com/6526607/134255132-11423c33-c4d9-4d29-9479-7265e4711094.png">
<img width="1611" alt="Screenshot 2021-09-20 at 19 31 16" src="https://user-images.githubusercontent.com/6526607/134255135-d43103ba-a37d-4aec-b409-a7a6b9a57f8e.png">

  


