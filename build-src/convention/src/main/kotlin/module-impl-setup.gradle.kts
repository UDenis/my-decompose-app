plugins {
    id("multiplatform-compose-setup")
    id("kotlinx-serialization")
    id("com.google.devtools.ksp")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                // Koin
                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
                //api(libs.koin.annotations)
                // Koin Annotations

                implementation(libs.ktor.core)

                api(libs.mvi)
                api(libs.log)
                implementation(libs.kotlinX.serialization.json)

                api(libs.decompose.compose.extension)
                api(libs.decompose.core)
                api(libs.essenty.coroutines)

                implementation(libs.coroutines.core)

                implementation(project(":core:di"))
                implementation(project(":core:decompose"))
                implementation(project(":core:design"))
                implementation(project(":core:coroutines"))
            }
        }
        androidMain {
            dependencies {
                implementation(libs.coroutines.android)
            }
        }
    }

    // KSP Common sourceSet
//    sourceSets.named("commonMain").configure {
//        kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
//    }
}

//// KSP Tasks
//dependencies {
//    add("kspCommonMainMetadata", libs.koin.ksp.compiler)
//    add("kspAndroid", libs.koin.ksp.compiler)
//    add("kspIosX64", libs.koin.ksp.compiler)
//    add("kspIosArm64", libs.koin.ksp.compiler)
//    add("kspIosSimulatorArm64", libs.koin.ksp.compiler)
//}
//
//// Trigger Common Metadata Generation from Native tasks
//project.tasks.withType<KotlinCompilationTask<*>>().configureEach {
//    if(name != "kspCommonMainKotlinMetadata") {
//        dependsOn("kspCommonMainKotlinMetadata")
//    }
//}
