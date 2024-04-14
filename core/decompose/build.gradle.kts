plugins {
    id("multiplatform-compose-setup")
}

android {
    namespace = "ru.otp.core.decompose"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(libs.decompose.core)
            }
        }
    }
}

