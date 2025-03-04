# tbcMiddleProject

This application is designed for users to discover and try a wide variety of recipes for the same dishes.
Users can view recipes along with their public ratings, ingredients, and an image of the final dish.
They also have the option to visit the original recipe author’s URL to read a more detailed version.
The app allows users to register, complete their profile information, and embark on a journey through a diverse world of recipes.
This application features a bilingual interface, allowing users to seamlessly switch between English and Georgian. By default, the app automatically detects the system language of the user's device, ensuring an intuitive and personalized experience from the start.
Registration: Users can register by providing their email address and a username.

Email Verification: After registration, a 4-digit verification code (OTP) is sent to the provided email. To complete the registration process and activate the account, users simply need to enter the OTP in the application.

Profile Completion: Once the email is verified, users are prompted to fill out additional personal information to create a fully personalized profile.

Profile Management: On the profile page, users can edit and save their information, as well as log out when desired.

Main Page: After completing the registration and profile setup, users are directed to the main page where they can explore a variety of new recipes and delightful flavors. 

Offline-First Strategy: The app employs an offline-first strategy, allowing users to access previously viewed recipes even without an internet connection.

Technical Overview :

Platform & Language:

Android application developed using Kotlin.
Architecture:

Implements Clean Architecture with clear separation of concerns:
Presentation Layer: Utilizes Fragments, ViewModels, and View Binding for UI and state management.
Domain Layer: Contains use cases for business logic and defines repository interfaces to ensure a clear contract for data operations.
Data Layer: Provides concrete implementations of the repository interfaces defined in the Domain Layer, promoting better abstraction and maintainability.
Navigation:

Uses a Navigation Graph with Safe Args for type-safe argument passing between fragments.
Networking & Data Handling:

Retrofit for HTTP requests.
Kotlin Serialization for deserializing HTTP responses.
Room Database for offline-first capabilities, combined with Paging3 (via Pager) to efficiently load items.
Image Loading:

Glide is used for image loading with an abstraction layer in place, making it easy to swap to Coil if needed.
The abstraction also allows for customizable placeholder and error images.
Dependency Injection:

Implemented using Dagger Hilt.
Local Storage:

DataStore for storing JWT tokens.
SharedPreferences for saving the user's preferred language.
User Interface Enhancements:

Utilizes the Splash Screen API for a smooth startup experience.
Recipes are displayed using a RecyclerView along with a dedicated adapter.




