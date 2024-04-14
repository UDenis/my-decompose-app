plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(libs.coroutines.core)
                api(libs.decompose.core)

                implementation(project(":core:decompose"))
            }
        }
    }
}
