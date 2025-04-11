plugins {
    id("multiplatform-setup")
    alias(libs.plugins.kotlinx.atomicfu)
}

android {
    namespace = "ru.otp.core.di"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.essenty.lifecycle)
                implementation(libs.decompose.core)
                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
            }
        }
    }
}