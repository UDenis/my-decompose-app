import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun BaseExtension.commonAndroid(target: Project) {
    configureDefaultConfig(target)

    target.suppressOptIn()
}

private fun BaseExtension.configureDefaultConfig(target: Project) {
    compileSdkVersion(target.libs.versions.compile.sdk.get().toInt())

    defaultConfig {
        minSdk = target.libs.versions.min.sdk.get().toInt()
    }
}

private fun Project.suppressOptIn() {
    tasks.withType<KotlinCompile>()
        .configureEach {
            compilerOptions {
                //jvmTarget.set(JvmTarget.JVM_1_8)
                freeCompilerArgs.add("-Xexpect-actual-classes")

                optIn.addAll(
                    "com.google.accompanist.pager.ExperimentalPagerApi",
                    "androidx.compose.ui.ExperimentalComposeUiApi",
                    "androidx.compose.foundation.ExperimentalFoundationApi",
                    "kotlinx.serialization.ExperimentalSerializationApi",
                    "kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "com.squareup.anvil.annotations.ExperimentalAnvilApi",
                    "kotlin.time.ExperimentalTime",
                    "kotlin.RequiresOptIn",
                    "androidx.compose.animation.ExperimentalAnimationApi",
                    "com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi",
                    "androidx.compose.foundation.layout.ExperimentalLayoutApi",
                    "com.google.android.horologist.annotations.ExperimentalHorologistApi"
                )
            }
        }
}
