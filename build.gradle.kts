// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        // kotlinx.atomicfu should be on classpath
        //  it's an implementation detail of kotlinx.atomicfu gradle plugin
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.kotlinX.atomicfu.gradle.plugin)
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
}
true // Needed to make the Suppress annotation work for the plugins block