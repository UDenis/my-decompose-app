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
                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)

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
