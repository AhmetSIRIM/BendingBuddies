# BendingBuddies

BendingBuddies app showcases The Last Airbender characters using MVVM architecture and comprehensive unit testing. It features a multi-module design for improved code readability and maintainability. The app displays a list of characters from the famous animated series, "The Last Airbender," following the MVVM pattern for clear component separation.

## Demo Gif

<h2 align="center">
  <a href="https://github.com/AhmetSIRIM/BendingBuddies">
    <img src="https://github.com/AhmetSIRIM/BendingBuddies/blob/master/BendingBuddiesDemo.gif" alt="BendingBuddiesDemoGif" width="50%" loop>
  </a>
</h2>

## Tech Stack & Open-source Libraries

- Minimum SDK level 24
- Contains Unit Tests
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) and [Flow](https://developer.android.com/kotlin/flow)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)
  - [Single-activity architecture](https://youtu.be/2k8x8V77CrU) → Utilizing a single activity with multiple fragments and the [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started) for seamless fragment management
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) → A data holder class for reactive data updates between ViewModel and UI, managing observer lifecycle automatically
  - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) → The Android Lifecycle library for managing component lifecycles and optimizing memory usage
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) → Stores UI-related data that isn't destroyed on UI changes
  - [UseCases](https://developer.android.com/topic/architecture/domain-layer) → Located domain layer that sits between the UI layer and the data layer
  - [Repository](https://developer.android.com/topic/architecture/data-layer) → Resides in the data layer and exposes data source functions
- [Material Design 3](https://m3.material.io/) → The latest version of Google’s open-source design system
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding) → Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views
- [Android Hilt](https://developer.android.com/training/dependency-injection/hilt-android) → A dependency injection library for Android that simplifies managing dependencies between application components, making the code more organized and flexible by automating dependency injection tasks
- [Retrofit](https://square.github.io/retrofit/) → A type-safe HTTP client for Android and Java
- [Coil](https://coil-kt.github.io/coil/) → An image-loading library for Android backed by Kotlin Coroutines
- [Splash Screen](https://developer.android.com/develop/ui/views/launch/splash-screen) → API for animated app launch with a splash screen, showing your app icon or animation, and smooth transition
- [Lottie](https://developer.android.com/develop/ui/views/launch/splash-screen) → Lightweight, scalable animations for your ads and social media

- Testing
  - [Mockito](https://site.mockito.org/) → A mocking framework that tastes really good. It lets you write beautiful tests with a clean & simple API
  - [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) → A scriptable web server for testing HTTP clients
  - [Truth](https://truth.dev/) → A library for performing assertions in tests
  - [Turbine](https://github.com/cashapp/turbine) → A small testing library for kotlinx.coroutines Flow

## Open API

[Last Airbender API](https://last-airbender-api.fly.dev/) → Open-source API that provides character information from Avatar: The Last Airbender

## Contact

<p align="start">
  <a href="https://www.linkedin.com/in/ahmetsirim/" target="_blank">
    <img src="https://img.shields.io/badge/LinkedIn-Ahmet%20SIRIM-blue?logo=linkedin" alt="LinkedIn">
  </a>
  <a href="mailto:ahmet.sirim@outlook.com" target="_blank">
    <img src="https://img.shields.io/badge/Email-ahmet.sirim%40outlook.com-red" alt="Email">
  </a>
</p>

## License

```xml
MIT License

Copyright (c) 2023 Ahmet SIRIM

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
