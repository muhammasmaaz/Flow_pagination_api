// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:4.1.3")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.47")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false
    id ("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id ("com.google.dagger.hilt.android") version "2.47" apply false

}