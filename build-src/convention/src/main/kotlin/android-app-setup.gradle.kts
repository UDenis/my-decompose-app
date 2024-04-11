plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "ru.otp.android"

    compileSdk = libs.versions.compile.sdk.get().toInt()
    defaultConfig {
        applicationId = "ru.otp.android"
        versionCode = 1
        versionName = "1.0"
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.compile.sdk.get().toInt()
    }

    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_17
//        targetCompatibility = JavaVersion.VERSION_17
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

}
