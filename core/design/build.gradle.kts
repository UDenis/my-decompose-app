plugins {
    id("android-lib-setup")
    id("android-compose-setup")
}

android {
    namespace = "ru.otp.core.design"
}

dependencies {
    api(libs.decompose.core)
}