plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "net.osdn.gokigen.watchface.prpr2.complications"
    compileSdk = 34

    defaultConfig {
        applicationId = "net.osdn.gokigen.watchface.prpr2.complications"
        minSdk = 34
        targetSdk = 34
        versionCode = 10000
        versionName = "1.0.0"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.play.services.wearable)
    implementation(libs.wear.complications.data.source)
    implementation(libs.wear.complications.data.source.ktx)
}
