plugins {
    id("multiplatform-compose-setup")
    id("kotlinx-serialization")
    kotlin("plugin.serialization")
}

android {
    dependencies {
        implementation(libs.ktor.core)

        api(libs.mvi)
        api(libs.log)
        implementation(libs.kotlinX.serialization.json)

        api(libs.decompose.compose.extension)
        api(libs.decompose.core)
        api(libs.essenty.coroutines)

        implementation(project(":core:di"))
        implementation(project(":core:decompose"))
        implementation(project(":core:design"))
        implementation(project(":core:coroutines"))

    }
}
