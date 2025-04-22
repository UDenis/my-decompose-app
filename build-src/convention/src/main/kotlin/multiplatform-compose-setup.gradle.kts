plugins {
    id("multiplatform-setup")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.androidx.ui.tooling)
            }
        }
        commonMain {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)

                api(libs.decompose.core)
                api(libs.decompose.compose.extension)
                api(libs.essenty.coroutines)
            }
        }
    }
}
