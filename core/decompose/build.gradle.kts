plugins {
    id("multiplatform-compose-setup")
}

android {
    namespace = "ru.otp.core.decompose"
}

dependencies {
    api(libs.decompose.core)
}