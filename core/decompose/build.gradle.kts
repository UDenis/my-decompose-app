plugins {
    id("android-lib-setup")
    id("android-compose-setup")
}


android {
    namespace = "ru.otp.core.decompose"
}

dependencies {
    api(libs.decompose.core)
}