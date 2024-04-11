plugins {
    id("com.android.library")
}

android {
    dependencies {
        api(libs.coroutines.core)
        api(libs.decompose.core)

        implementation(project(":core:decompose"))

    }
}
