plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "net.osdn.gokigen.watchface.prpr2"
    compileSdk = 34

    defaultConfig {
        applicationId = "net.osdn.gokigen.watchface.prpr2"
        minSdk = 34
        targetSdk = 34
        versionCode = 10000
        versionName = "1.0.0"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.play.services.wearable)
}
