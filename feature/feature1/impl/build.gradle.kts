plugins {
    id("module-impl-setup")
}

android {
    namespace = "ru.otp.feature1.impl"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.feature.feature1.api)
                implementation(projects.feature.feature2.api)
                
                // Koin
                implementation("io.insert-koin:koin-core:3.5.0")
                implementation("io.insert-koin:koin-android:3.5.0")
            }
        }
    }
}