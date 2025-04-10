plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
    maven(
        url = "https://maven.pkg.jetbrains.space/public/p/compose/dev",
    )
}

dependencies {
    implementation(libs.gradle.plugin.compose.multiplatform)
    implementation(libs.gradle.plugin.compose)
    implementation(libs.gradle.plugin.kotlin)
    implementation(libs.gradle.plugin.android)
    implementation(libs.gradle.plugin.serialization)
    implementation(libs.gradle.plugin.atomicfu)
    implementation(libs.gradle.plugin.ksp)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}