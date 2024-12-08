// build.gradle.kts (Project-level)

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Plugin de Hilt
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51.1")

        // Plugin de Gradle para Android
        classpath("com.android.tools.build:gradle:8.1.4")

        // Kotlin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
    }
}

rootProject.name = "Prueba"
include(":app")
