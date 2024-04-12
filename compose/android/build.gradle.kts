@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("multiplatform-compose-setup")
}

android {
    namespace = "ru.otp.app"
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.androidx.ktx)
                implementation(libs.androidx.activity.compose)
                implementation(libs.appcompat)
                implementation(libs.material)
                implementation(libs.decompose.android)


                implementation(projects.core.di)
                implementation(projects.core.decompose)
                implementation(projects.core.design)

                implementation(projects.feature.feature1.api)
                implementation(projects.feature.feature1.impl)

                implementation(projects.feature.feature2.api)
                implementation(projects.feature.feature2.impl)
            }
        }
    }
}