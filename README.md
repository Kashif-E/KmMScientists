# KmMScientists

KmMScientists is a **Kotlin multiplatform app** built with swift ui, jetpack compose, koin and realm.

# Whats Shared?
* Local Data Persistence with Realm
* Remote Data with KTOR
* Repository
* Use Cases
* Models
* Kotlin Parcelable Implementation
* Dependency Injection with koin on both IOS and Android
* Kotlin Flow


# Backend
  The backend module contains the backend code of this app. Ktor is used for building the backend with following apis
  * KTOR
  * Routing
  * Authentication
  * Locations
  * KMongo
  * Monitoring
  * Kotlinx Serialization
  * Koin


# UI
* Android UI is built with jetpack compose
* IOS UI is built with Swift ui


# How to run the app?
In order to run the app you need to have docker installed on your machine 
Steps:

1. Download or clone the repo
2. Open the repo in Intellij Idea or android studio 
3. Go to backend -> Scripts and run the docker compose script it will create the mongo database that the app is going to use
4. One the backend is working compile and run the app
5. As IOS and Android use different address to connect to local host there are two different base urls change the BASE_URL property in shared code accordingly path /shared/src/commonMain/kotlin/com/kashif/kmmscientists/data/remote/scientists_service/
6. Data will be empty but you can add using postman or add it by yourself from the backend code

# Screen Shots

|Platform|Screenshot|
|---|---|
|Android|<img src="/screenshots/android 2.png?raw=true" width=300/>|
|Android|<img src="/screenshots/android1.png?raw=true" width=300/>|
|IOS|<img src="/screenshots/ios 1.png?raw=true" width=300/>|
|IOS|<img src="/screenshots/ios2.png?raw=true" width=300/>|


References: 
Kampkit: https://github.com/touchlab/KaMPKit
Fantasy Premiere  League: https://github.com/joreilly/FantasyPremierLeague
Bike Share: https://github.com/joreilly/BikeShare

