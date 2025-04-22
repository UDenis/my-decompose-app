import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

class MultiplatformDependenciesPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.kotlin.sourceSets.forEach { sourceSet ->
            val noMainSourceSetName = sourceSet.name.removeSuffix(MAIN_SOURCE_SET_POSTFIX)
            sourceSet.dependencies {
                target.extensions.create(
                    "${noMainSourceSetName}Dependencies",
                    MultiplatformDependenciesScope::class,
                    this
                )
            }
        }
    }

    companion object {
        /**
         * The postfix of default source set naming aka commonMain, androidMain etc
         */
        private const val MAIN_SOURCE_SET_POSTFIX = "Main"
    }
}

open class MultiplatformDependenciesScope(
    handler: KotlinDependencyHandler
) : KotlinDependencyHandler by handler