@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.ksp)
    id("android-app-setup")
    id("multiplatform-dependencies")
}

kotlin {
    androidTarget()
    sourceSets {
        androidMain {
            dependencies {
                implementation(projects.umbrella)
                implementation(projects.core.di)
                implementation(libs.kotlin.inject.runtime)
                implementation(libs.kotlin.inject.anvil.runtime)
                implementation(libs.kotlin.inject.anvil.runtime.optional)
            }
        }
    }
}

dependencies {
    implementation(projects.core.di)
    implementation(libs.kotlin.inject.runtime)
    implementation(libs.kotlin.inject.anvil.runtime)
}


dependencies {
    add("kspCommonMainMetadata", libs.kotlin.inject.ksp)
    add("kspAndroid", libs.kotlin.inject.ksp)
    add("kspIosArm64", libs.kotlin.inject.ksp)
    add("kspIosX64", libs.kotlin.inject.ksp)
    add("kspIosSimulatorArm64", libs.kotlin.inject.ksp)
    //add("kspDesktop", libs.kotlin.inject.ksp)

    add("kspCommonMainMetadata", libs.kotlin.inject.anvil.ksp)
    add("kspAndroid", libs.kotlin.inject.anvil.ksp)
    add("kspIosArm64", libs.kotlin.inject.anvil.ksp)
    add("kspIosX64", libs.kotlin.inject.anvil.ksp)
    add("kspIosSimulatorArm64", libs.kotlin.inject.anvil.ksp)
    //add("kspDesktop", libs.kotlin.inject.anvil.ksp)
}