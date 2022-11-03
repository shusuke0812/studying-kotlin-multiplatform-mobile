plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.kotlinmultiplatformsandbox.android"
        minSdk = 25
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    namespace = "com.example.kotlinmultiplatformsandbox.android"
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("androidx.compose.material:material:1.2.1")
    implementation("androidx.compose.runtime:runtime:1.4.0-alpha01")
    implementation("androidx.compose.runtime:runtime-livedata:1.4.0-alpha01")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.4.0-alpha01")
    implementation("androidx.activity:activity-compose:1.6.0")
}