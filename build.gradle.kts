buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.2.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${Versions.DAGGER_HILT}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}