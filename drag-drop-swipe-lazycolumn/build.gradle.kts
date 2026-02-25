import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.vanniktech.maven.publish)
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

mavenPublishing {
    publishToMavenCentral(automaticRelease = true)
    signAllPublications()

    coordinates(
        groupId = group.toString(),
        artifactId = "drag-drop-swipe-lazycolumn",
        version = version.toString(),
    )

    pom {
        name.set("DragDropSwipeLazyColumn")
        url.set("https://github.com/ernestoyaquello/DragDropSwipeLazyColumn")
        inceptionYear.set("2025")
        description.set(
            "Kotlin Android library for Jetpack Compose that implements a lazy column" +
                "with drag-and-drop reordering and swipe-to-dismiss functionality.",
        )

        licenses {
            license {
                name.set("MIT License")
                url.set("https://opensource.org/license/mit")
                distribution.set("https://opensource.org/license/mit")
            }
        }

        developers {
            developer {
                id.set("ernestoyaquello")
                name.set("Julio Ernesto Rodríguez Cabañas")
                url.set("https://julioernesto.me/")
            }
        }

        scm {
            url.set("https://github.com/ernestoyaquello/DragDropSwipeLazyColumn/")
            connection.set("scm:git:git://github.com/ernestoyaquello/DragDropSwipeLazyColumn.git")
            developerConnection.set("scm:git:ssh://git@github.com/ernestoyaquello/DragDropSwipeLazyColumn.git")
        }
    }
}
