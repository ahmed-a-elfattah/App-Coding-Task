plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = Dependencies.Android.compileSdk

    defaultConfig {
        applicationId = Dependencies.Android.applicationId
        minSdk = Dependencies.Android.minSdk
        targetSdk = Dependencies.Android.targetSdk
        versionCode = Dependencies.Android.versionCode
        versionName = Dependencies.Android.versionName
        testInstrumentationRunner = Dependencies.Android.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs= listOf("-Xjvm-default=all")
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Dependencies.SupportLibs.core_ktx)
    implementation(Dependencies.SupportLibs.appcompat)
    implementation(Dependencies.SupportLibs.constraintlayout)
    implementation(Dependencies.SupportLibs.material)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.gson)
    implementation(Dependencies.Retrofit.converter_gson)
    implementation(Dependencies.Retrofit.logging_interceptor)
    implementation(Dependencies.Retrofit.adapter_rxjava)

    implementation(Dependencies.Rx.rxandroid)
    implementation(Dependencies.Rx.rx)

    implementation(Dependencies.Dagger.dagger2)
    kapt(Dependencies.Dagger.dagger_compiler)
    implementation(Dependencies.Dagger.dagger_android)
    implementation(Dependencies.Dagger.dagger_android_support)
    kapt(Dependencies.Dagger.dagger_android_processor)

    implementation(Dependencies.JetBack.viewmodel)

    testImplementation(Dependencies.TestLibs.junit)
    androidTestImplementation(Dependencies.TestLibs.extJunit)
    androidTestImplementation(Dependencies.TestLibs.espresso_core)
}