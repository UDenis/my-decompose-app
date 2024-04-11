plugins {
    id("multiplatform-setup")
    id("android-lib-setup")
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