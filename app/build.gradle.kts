plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.myproject"
    compileSdk = libs.versions.compileSdk.get().toInt()
    ndkVersion = "25.2.9519653"

    defaultConfig {
        applicationId = "com.example.myproject"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
        }
    }

    buildFeatures {
        dataBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

dependencies {

    implementation(libs.bundles.androidX)
    implementation(libs.bundles.okhttp)

    implementation(libs.bundles.room)
    ksp(libs.roomCompiler)

    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.navigation)

    //GLide
    implementation(libs.glide)
    ksp(libs.glideCompiler)
    annotationProcessor(libs.glideCompiler)

    // logs
    debugImplementation(libs.chuckerLib)
//    releaseImplementation(libs.chuckerNoOp)
    implementation(libs.timber)

    implementation(libs.hiltAndroid)
    implementation(libs.liveData)
    implementation(libs.lifecycleVM)
    kapt(libs.hiltCompilerAndroid)

    implementation(libs.lottie)

}