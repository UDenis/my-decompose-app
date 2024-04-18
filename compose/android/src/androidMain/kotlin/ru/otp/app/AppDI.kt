package ru.otp.app

import android.util.Log
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.di.ComponentDeps
import ru.otp.core.di.DIComponent
import ru.otp.core.di.DIComponentHolder
import ru.otp.feature1.api.di.Feature1DI

class AppDI(
    private val diComponents: List<Class<*>>
) {

    private val diComponentHolders = HashMap<Class<*>, DIComponentHolder<out DIComponent>>()

    inline fun <reified T : DIComponent> getComponent(lifecycleOwner: LifecycleOwner): T {
        return getComponent(T::class.java, lifecycleOwner)
    }

    fun <T : DIComponent> getComponent(cl: Class<T>, lifecycleOwner: LifecycleOwner): T {
        return getDIComponentHolder(cl).get(lifecycleOwner)
    }

    private fun <T : DIComponent> getDIComponentHolder(cl: Class<T>): DIComponentHolder<T> {
        var diComponentHolder = diComponentHolders[cl] as? DIComponentHolder<T>
        if (diComponentHolder == null) {
            synchronized(this) {
                if (diComponentHolder == null) {
                    diComponentHolder = DIComponentHolder {
                        createDIComponent(cl)
                    }
                    diComponentHolders[cl] = diComponentHolder as DIComponentHolder<T>
                }
            }
        }
        return diComponentHolder!!
    }

    private fun <T : DIComponent> createDIComponent(cl: Class<T>): T {
        val kclass = diComponents.firstOrNull {
            it == cl || it.superclass == cl
        }?.kotlin ?: throw RuntimeException("DIComponent for $cl not found")

        Log.d("DDD", "createDIComponent $kclass")
        val constructor = kclass.constructors.firstOrNull()
            ?: throw RuntimeException("Constructor for DIComponent $cl not found")

        val deps =
            (kclass.annotations.firstOrNull { it is ComponentDeps } as? ComponentDeps)?.deps.orEmpty()
        if (constructor.parameters.size != deps.size) {
            throw RuntimeException("Invalid args")
        }

        return if (deps.size > 0) {
            val args = deps.map {
                getDIComponentHolder(it.java)
            }.toTypedArray()
            constructor.call(*args) as T
        } else {
            constructor.call() as T
        }
    }

    fun homeComponentFactory(componentContext: ComponentContext): DecomposeComponent {
        return getComponent<Feature1DI>(componentContext).homeComponentFactory(componentContext)
    }
}
