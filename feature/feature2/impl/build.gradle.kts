plugins {
    id("android-lib-setup")
    id("android-compose-setup")
    id("module-impl-setup")
    id("kotlinx-serialization")
}

android {
    namespace = "ru.otp.feature2.impl"
}

dependencies {
    implementation(projects.feature.feature2.api)
    implementation(projects.feature.feature1.api)
}