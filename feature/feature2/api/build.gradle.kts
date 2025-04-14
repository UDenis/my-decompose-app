plugins {
    id("module-api-setup")
}

android {
    namespace = "ru.otp.feature2.api"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.feature.feature1.api)
            }
        }
    }
}