/**
 * Precompiled [android-lib-setup.gradle.kts][Android_lib_setup_gradle] script plugin.
 *
 * @see Android_lib_setup_gradle
 */
public
class AndroidLibSetupPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Android_lib_setup_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
