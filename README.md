# NewsAppDemo (Compose Multiplatform_

This is an exploration app for Compose Multiplatform UI. Currently this app have Android, iOS and it is 100% Compose UI. For more details on Compose Multiplatform UI visit: https://github.com/JetBrains/compose-jb/
The support for iOS on Compose Multiplatform is still in experimental phase.
I'll be adding desktop and web versions soon. 

The code follows clean architecture approach keeping the data, domain and presentation layer separate. 

## Libraries

- kotlinx coroutines
- ktor (HTTP client)
- Koin (Dependency Injection)
- Jetbrains Compose
- Moko for MVVM

For rest api, I am using [NewsAPI](https://newsapi.org/)

Current supported Platforms are:
1. Android
2. iOS

Upcoming Supported Platform for this Demo: 
1. Desktop
2. Web

## Running the App:
For running the app, you need an api to feed data. For Rest api, I am using [NewsAPI](https://newsapi.org/). You need to create a free account, get your api key and add it API_KEY in KtorApi class

## iOS
https://github.com/NikhilBhutani/ComposeMultiplatformNewsAppDemo/assets/7945225/da1745fd-56d6-4729-884c-6816551d6d23


## Android
[Screen_recording_20231229_171356.webm](https://github.com/NikhilBhutani/ComposeMultiplatformNewsAppDemo/assets/7945225/e9356fc8-1587-4ebc-afaf-6328dca6f0ed)



