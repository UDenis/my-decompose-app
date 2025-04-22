plugins {
    id("multiplatform-compose-setup")
    id("kotlinx-serialization")
    id("com.google.devtools.ksp")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.inject.runtime)
                implementation(libs.kotlin.inject.anvil.runtime)
                implementation(libs.kotlin.inject.anvil.runtime.optional)

                implementation(libs.ktor.core)

                api(libs.mvi)
                api(libs.log)
                implementation(libs.kotlinX.serialization.json)

                api(libs.decompose.compose.extension)
                api(libs.decompose.core)
                api(libs.essenty.coroutines)

                implementation(libs.coroutines.core)

                implementation(project(":core:di"))
                implementation(project(":core:decompose"))
                implementation(project(":core:design"))
                implementation(project(":core:coroutines"))
            }
        }
        androidMain {
            dependencies {
                implementation(libs.coroutines.android)
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

