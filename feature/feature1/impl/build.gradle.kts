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
            }
        }
    }
}