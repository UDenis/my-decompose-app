plugins {
    id("android-lib-setup")
    id("org.jetbrains.compose")
}

android {
    composeOptions {
        //kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    api(compose.runtime)
    api(compose.foundation)
    api(compose.material)
    api(compose.preview)

    api(libs.decompose.compose.extension)
    api(libs.essenty.coroutines)
    api(libs.decompose.core)
}