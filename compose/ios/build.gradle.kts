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
                    export(libs.decompose.core)
                    export(libs.essenty.lifecycle)
                    export(projects.compose.android)

                    export(projects.core.di)
                    export(projects.core.decompose)
                    export(projects.core.design)

                    export(projects.feature.feature1.api)
                    export(projects.feature.feature1.impl)

                    export(projects.feature.feature2.api)
                    export(projects.feature.feature2.impl)
                }
            }
        }

    sourceSets {
        iosMain {
            dependencies {
                api(libs.essenty.lifecycle)
                api(libs.decompose.core)

                api(projects.compose.android)

                api(projects.core.di)
                api(projects.core.decompose)
                api(projects.core.design)

                api(projects.feature.feature1.api)
                api(projects.feature.feature1.impl)

                api(projects.feature.feature2.api)
                api(projects.feature.feature2.impl)
            }
        }
    }
}