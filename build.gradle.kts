import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.compose.multiplatform)
}

group = "com.ernestoyaquello.dragdropswipelazycolumn"
version = "0.10.2"

kotlin {
    androidLibrary {
        namespace = "com.ernestoyaquello.dragdropswipelazycolumn"
        compileSdk = 36
        minSdk = 23
        androidResources {
            enable = true
        }
    }

    jvm("desktop") {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.jetbrains.compose.runtime)
                implementation(libs.jetbrains.compose.foundation)
                implementation(libs.jetbrains.compose.material3)
                implementation(libs.jetbrains.compose.components.resources)
                implementation(libs.kotlinx.collections.immutable)
            }
        }
    }
}

compose.resources {
    packageOfResClass = "com.ernestoyaquello.dragdropswipelazycolumn.resources"
}
