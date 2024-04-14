@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("android-app-setup")
}

dependencies {
    implementation(projects.compose.android)
}