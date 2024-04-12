import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.Family

plugins {
    id("multiplatform-compose-setup")
}

android {
    namespace = "ru.otp.ios"
}


kotlin {
    targets
        .filterIsInstance<KotlinNativeTarget>()
        .filter { it.konanTarget.family == Family.IOS }
        .forEach {
            it.binaries {
                framework {
                    baseName = "Shared"
                }
            }
        }

    sourceSets {
        iosMain {
            dependencies {
                implementation(projects.core.di)
                implementation(projects.core.decompose)
                implementation(projects.core.design)

                implementation(projects.feature.feature1.api)
                implementation(projects.feature.feature1.impl)

                implementation(projects.feature.feature2.api)
                implementation(projects.feature.feature2.impl)
            }
        }
    }
}