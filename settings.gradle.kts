enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-src")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(
            url = "https://maven.pkg.jetbrains.space/public/p/compose/dev",
        )
    }
}

rootProject.name = "OTP-app"
include(":app")
include(":target")
include(":target:google")

include(":core")
include(":core:di")
include(":core:decompose")
include(":core:design")
include(":core:coroutines")


include(":feature")

include(":feature:feature1")
include(":feature:feature1:api")
include(":feature:feature1:impl")

include(":feature:feature2")
include(":feature:feature2:api")
include(":feature:feature2:impl")
