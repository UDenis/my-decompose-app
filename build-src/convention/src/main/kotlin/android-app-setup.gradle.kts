import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.multiplatform")
}

android {
    commonAndroid(project)
    namespace = "ru.otp.android"

    defaultConfig {
        applicationId = "ru.otp.android"
        versionCode = 1
        versionName = "1.0"
        targetSdk = libs.versions.compile.sdk.get().toInt()
    }
    packaging {
        resources {
            //excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/*"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {

            }
        }
    }
}

includeCommonKspConfigurationTo("ksp")