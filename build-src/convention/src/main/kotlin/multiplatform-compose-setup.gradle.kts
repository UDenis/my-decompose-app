plugins {
    id("multiplatform-setup")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)

                api(libs.decompose.compose.extension)
                api(libs.essenty.coroutines)
                api(libs.decompose.core)
            }
        }
    }
}
