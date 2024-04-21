# RegistrationForm with Firebase in Android Studio

This repository contains an Android application built using Java and Firebase. 
The app offers a registration form where users can register by providing their Student Registration Number (SRN), Name, Pincode, Email ID, and Phone Number.
The user registration data is securely stored in Firebase's Firestore database.

## Features

- **User Registration:** Users can register by providing their SRN, Name, Pincode, Email ID, and Phone Number.
- **Data Validation:** Client-side validation to ensure data integrity before sending to Firebase.
- **Firebase Integration:** Securely store user data in Firestore.
- **Error Handling:** Proper error handling and feedback to the user for a seamless registration experience.

## Technologies Used

- Android Studio: For Android application development.
- Java: Programming language used for Android app development.
- Firebase Firestore: To store and manage user registration data.

## Installation

1. Clone the Repository

    ```bash
    git clone https://github.com/yourusername/RegistrationFormAndroid.git
    ```

2. Open Project in Android Studio

    - Launch Android Studio and select "Open an existing Android Studio project."
    - Navigate to the cloned repository and select the `RegistrationFormAndroid` directory to open the project.

3. Firebase Setup

    - Create a Firebase project at [Firebase Console](https://console.firebase.google.com/)
    - Enable Firestore database
    - Add an Android app to your Firebase project to get your Firebase configuration details (google-services.json file)

4. Update Firebase Configuration

    - Replace the `google-services.json` file in the `app` directory with your own Firebase configuration file.
    - You can find this file in your Firebase project settings.

## Configuration

1. Firebase Dependencies

    In your app-level `build.gradle` file, make sure you have the following Firebase dependencies:

    ```gradle
    implementation 'com.google.firebase:firebase-auth:21.0.1'
    implementation 'com.google.firebase:firebase-firestore:23.0.3'
    ```

2. Firebase Configuration

    Ensure your `AndroidManifest.xml` has the necessary internet and Firebase configurations:

    ```xml
    <uses-permission android:name="android.permission.INTERNET" />

    <application>
        <!-- Add this after application tag -->
        <meta-data
            android:name="com.google.firebase.components:com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar"
            android:value="com.google.firebase.components.ComponentRegistrar" />
    </application>
    ```

3. Update Firebase Initialization

    In your `MainActivity.java` or where you initialize Firebase, ensure you initialize Firebase with the correct configuration:

    ```java
    FirebaseApp.initializeApp(this);
    ```

## Usage

Run the app on an Android emulator or a physical device. You should see a registration form where you can enter your SRN, Name, Pincode, Email ID, and Phone Number. After filling in the details and submitting the form, the data should be stored in Firebase Firestore.

That's it! You now have a registration form Android app integrated with Firebase Firestore. Feel free to modify and extend the app as per your requirements.
