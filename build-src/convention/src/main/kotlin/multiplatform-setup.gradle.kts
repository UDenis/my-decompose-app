import com.android.build.gradle.BaseExtension

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

configure<BaseExtension> {
    commonAndroid(project)
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {

            }
        }
    }
}

includeCommonKspConfigurationTo("kspAndroid")
