pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(
            url = "https://maven.pkg.jetbrains.space/public/p/compose/dev",
        )
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "build-src"

include(
    ":convention"
)