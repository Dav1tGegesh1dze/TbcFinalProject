# 📦 DeliveryApp - PontiDelivery
An Android delivery app developed using Kotlin in Android Studio. This project follows Clean Architecture and the MVI (Model-View-Intent) pattern to ensure maintainable, scalable, and testable code. The app utilizes **Dagger Hilt** for dependency injection, **Kotlin Serialization** for parsing data, and is primarily XML-based, with a single fragment containing a **Jetpack Compose Composable** UI.

---

## 🧱 Architecture Overview

This app is built using **Clean Architecture** principles and the **MVI** pattern:

- **Presentation Layer**: Contains a Composable-based Fragment, ViewModel (with State, Intent, and Effect), and XML layout files.
- **Domain Layer**: Includes UseCases and Domain Models. Pure Kotlin, no Android dependencies.
- **Data Layer**: Manages repositories, network, and data sources. Uses Kotlin Serialization for data parsing.

---

## ✨ Features

- 📦 Clean Architecture with strict separation of concerns
- 🔁 MVI pattern (State, Intent, Effect)
- 💉 Dependency Injection with **Dagger Hilt**
- 📜 Kotlin Serialization for efficient and lightweight data handling
- 🧩 Composable Fragment (Jetpack Compose UI within XML project)
- 🧪 Easy to extend, test, and scale

---

## 📁 Project Structure

