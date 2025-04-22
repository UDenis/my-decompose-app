import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.Family

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("multiplatform-compose-setup")
    id("com.google.devtools.ksp")
}

android {
    namespace = "ru.otp.app"
}

kotlin {
    sourceSets {
        targets
            .filterIsInstance<KotlinNativeTarget>()
            .filter { it.konanTarget.family == Family.IOS }
            .forEach {
                it.binaries {
                    framework {
                        baseName = "Shared"
                        export(libs.decompose.core)
                        export(libs.essenty.lifecycle)

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

        commonMain {
            dependencies {
                implementation(libs.kotlin.inject.runtime)
                implementation(libs.kotlin.inject.anvil.runtime)
                implementation(libs.kotlin.inject.anvil.runtime.optional)

                api(projects.core.di)
                api(projects.core.decompose)
                api(projects.core.design)

                api(projects.feature.feature1.api)
                api(projects.feature.feature1.impl)

                api(projects.feature.feature2.api)
                api(projects.feature.feature2.impl)

            }
        }

        androidMain {
            dependencies {
                implementation(libs.decompose.android)
                implementation(libs.androidx.ktx)
                implementation(libs.androidx.activity.compose)
                implementation(libs.appcompat)
                implementation(libs.material)
            }
        }

        iosMain {
            dependencies {
                api(libs.essenty.lifecycle)
                api(libs.decompose.core)

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

dependencies {
    add("kspCommonMainMetadata", libs.kotlin.inject.ksp)
    add("kspAndroid", libs.kotlin.inject.ksp)
    add("kspIosArm64", libs.kotlin.inject.ksp)
    add("kspIosX64", libs.kotlin.inject.ksp)
    add("kspIosSimulatorArm64", libs.kotlin.inject.ksp)

    add("kspCommonMainMetadata", libs.kotlin.inject.anvil.ksp)
    add("kspAndroid", libs.kotlin.inject.anvil.ksp)
    add("kspIosArm64", libs.kotlin.inject.anvil.ksp)
    add("kspIosX64", libs.kotlin.inject.anvil.ksp)
    add("kspIosSimulatorArm64", libs.kotlin.inject.anvil.ksp)
}

