import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

val copyJsResources = tasks.create("copyJsResourcesWorkaround", Copy::class.java) {
    from(project(":shared").file("src/commonMain/resources"))
    into("build/processedResources/js/main")
}

val copyWasmResources = tasks.create("copyWasmResourcesWorkaround", Copy::class.java) {
    from(project(":shared").file("src/commonMain/resources"))
    into("build/processedResources/wasm/main")
}

afterEvaluate {
    project.tasks.getByName("jsProcessResources").finalizedBy(copyJsResources)
    project.tasks.getByName("wasmProcessResources").finalizedBy(copyWasmResources)
}

kotlin {
    js(IR) {
        moduleName = "myportfolio"
        browser()
        binaries.executable()
    }

    wasm {
        moduleName = "myportfolio"
        browser {
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).copy(
                    open = mapOf(
                        "app" to mapOf(
                            "name" to "google chrome",
                        )
                    ),
                )
            }
        }
        binaries.executable()
    }

    sourceSets {
        val jsWasmMain by creating {
            dependencies {
                implementation(project(":shared"))
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }
        val jsMain by getting {
            dependsOn(jsWasmMain)
        }
        val wasmMain by getting {
            dependsOn(jsWasmMain)
        }
    }
}

compose.experimental {
    web.application {}
}
