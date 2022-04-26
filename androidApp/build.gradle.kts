plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.devtools.ksp") version "1.6.10-1.0.2"

}
kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}
android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.kashif.kmmscientists.android"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("META-INF/**/*")
        exclude("META-INF/common.kotlin_module")
        exclude("META-INF/*.kotlin_module")
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-alpha07"
    }

}

dependencies {
    implementation(project(":shared"))
    implementation(Compose.activity)
    implementation(ComposeDestination.composeDestination)
    implementation(Compose.compiler)
    implementation(SplashScreen.splashScreen)
    implementation(Accompanist.coil)
    implementation(Compose.constraintLayout)
    implementation(Shimmer.shimmer)
    implementation(ComposeDestination.core)
    ksp(ComposeDestination.composeDestinationPlugin)
    implementation(Compose.foundation)
    implementation(Koin.koinAndroid)
    implementation(Compose.material)
    implementation(Compose.navigation)
    implementation(Compose.runtime)
    implementation(Accompanist.systemUIController)
    implementation(Compose.ui)
    implementation(Compose.uiTooling)

}