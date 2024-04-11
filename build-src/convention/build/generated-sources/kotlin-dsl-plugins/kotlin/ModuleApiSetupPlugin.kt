/**
 * Precompiled [module-api-setup.gradle.kts][Module_api_setup_gradle] script plugin.
 *
 * @see Module_api_setup_gradle
 */
public
class ModuleApiSetupPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Module_api_setup_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
