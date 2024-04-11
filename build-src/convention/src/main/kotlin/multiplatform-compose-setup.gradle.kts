plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

//    iosX64()
//    iosArm64()
//    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(compose.preview)

                api(libs.decompose.compose.extension)
                api(libs.essenty.coroutines)
                api(libs.decompose.core)
            }
        }
    }
}
