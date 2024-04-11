plugins {
    id("android-lib-setup")
}


android {
    namespace = "ru.otp.core.di"
}

dependencies {
    implementation(libs.essenty.lifecycle)
}