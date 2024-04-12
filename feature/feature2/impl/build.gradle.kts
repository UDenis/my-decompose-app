plugins {
    id("module-impl-setup")
}

android {
    namespace = "ru.otp.feature2.impl"
}

dependencies {
    implementation(projects.feature.feature2.api)
    implementation(projects.feature.feature1.api)
}