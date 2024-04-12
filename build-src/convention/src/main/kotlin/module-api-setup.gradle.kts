plugins {
    id("multiplatform-setup")
}

android {
    dependencies {
        api(libs.coroutines.core)
        api(libs.decompose.core)

        implementation(project(":core:decompose"))

    }
}
