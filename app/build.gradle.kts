plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id ("kotlin-parcelize")
    kotlin("plugin.serialization") version "2.0.21"
    id ("androidx.navigation.safeargs.kotlin") version "2.8.7"
    id ("kotlin-kapt")
    id ("com.google.protobuf") version "0.9.4"
    id ("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")

}

android {
    namespace = "com.example.middlecourseproject"
    compileSdk = 35

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.example.middlecourseproject"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false

            buildConfigField("String", "BASE_URL", "\"http://54.93.212.178\"")
            buildConfigField("String", "BASE_FOOD_URL", "\"https://forkify-api.herokuapp.com/api/\"")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            buildConfigField("String", "BASE_URL", "\"http://54.93.212.178\"")
            buildConfigField("String", "BASE_FOOD_URL", "\"https://forkify-api.herokuapp.com/api/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation ("com.google.android.material:material:<version>")
    implementation (libs.androidx.core.splashscreen)

    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)
    implementation(libs.logging.interceptor)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.fragment)
    implementation  (libs.androidx.datastore)
    implementation  (libs.protobuf.javalite)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.datastore.preferences)
    implementation (libs.glide)
    implementation (libs.moshi.kotlin.codegen)
    implementation(libs.moshi)
    implementation (libs.moshi.kotlin)
    implementation (libs.logging.interceptor)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.androidx.navigation.dynamic.features.fragment)
    implementation (libs.material.v190)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //new ones


}


