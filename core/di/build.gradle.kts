plugins {
    id("multiplatform-setup")
    id("kotlinx-atomicfu")
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