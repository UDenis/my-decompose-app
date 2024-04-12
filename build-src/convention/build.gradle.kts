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
    implementation(libs.compose.multiplatform.gradle)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.android.gradle.plugin)
    implementation(libs.serialization.gradle.plugin)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}