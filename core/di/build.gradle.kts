plugins {
    id("multiplatform-setup")
}

android {
    namespace = "ru.otp.core.di"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.essenty.lifecycle)
            }
        }
    }
}