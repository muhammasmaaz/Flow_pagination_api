plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")

    //must for hilt
    id ("kotlin-android")
    id ("com.google.dagger.hilt.android")
    id ("dagger.hilt.android.plugin")


}

android {
    namespace = "com.example.flow_pagination_api"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.flow_pagination_api"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    buildFeatures{
        viewBinding=true
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    hilt {
        enableAggregatingTask = true
    }
}

dependencies {


    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.8")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val lifecycle_version = "2.6.1"
    val paging_version = "3.2.0"
    val hilt_version="2.47"

    //paging 3
    implementation ("androidx.paging:paging-runtime:$paging_version")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata:$lifecycle_version")

    //dagger hilt
    implementation ("com.google.dagger:hilt-android:$hilt_version")
    kapt ("com.google.dagger:hilt-compiler:$hilt_version")
    kapt("com.google.dagger:hilt-android-compiler:2.47")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")
//    implementation  ("androidx.hilt:hilt-lifecycle-viewmodel:2.47")
    implementation ("com.google.dagger:dagger:2.47")
    kapt ("com.google.dagger:dagger-compiler:2.47")
    //kotlin Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")


    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //moshi is light weight than the json
    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

    // android ktx view model depency prviode easy
    implementation ("androidx.activity:activity-ktx:1.7.2")

    //hilt viewmodel is deprecated dont add it
//    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")

    //coil reaplacement of glide supported to kotlin
    implementation("io.coil-kt:coil:1.2.0")

    implementation ("androidx.multidex:multidex:2.0.1")


}
kapt {
    correctErrorTypes = true
}
