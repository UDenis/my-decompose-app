import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

// Workaround for https://github.com/gradle/gradle/issues/15383
val Project.libs: LibrariesForLibs
    get() = the<LibrariesForLibs>()

val Project.kotlin: KotlinMultiplatformExtension
    get() {
        val extensionAware = (this as org.gradle.api.plugins.ExtensionAware)
        val kotlinExtension = extensionAware.extensions.getByName("kotlin")
        return kotlinExtension as KotlinMultiplatformExtension
    }