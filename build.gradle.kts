import org.jetbrains.kotlin.gradle.dsl.JvmTarget

// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        // kotlinx.atomicfu should be on classpath
        //  it's an implementation detail of kotlinx.atomicfu gradle plugin
        classpath(libs.gradle.plugin.kotlin)
        classpath(libs.gradle.plugin.atomicfu)
    }
}

plugins {
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlinx.atomicfu) apply false
    id("java-versions") apply false
}

allprojects {
    apply(plugin = "java-versions")
}

true // Needed to make the Suppress annotation work for the plugins block