plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

kotlin {
    jvmToolchain(17)

    androidTarget()

//    iosX64()
//    iosArm64()
//    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {

            }
        }
    }
}
