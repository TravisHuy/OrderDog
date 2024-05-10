plugins {
    id("com.android.application") version "7.3.0" apply false
    id("com.android.library") version "7.3.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
buildscript {
    extra.apply {
        set("lifecycle_version", "2.6.1")
    }
    dependencies{
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21")
    }
}