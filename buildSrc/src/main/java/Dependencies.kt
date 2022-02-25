object Versions {

    object BuildPlugins{
        const val application="7.1.2"
        const val library="7.1.2"
        const val kotlin="1.6.10"
    }

    const val core_ktx = "1.7.0"
    const val appcompat = "1.4.1"
    const val material = "1.5.0"
    const val constraintlayout = "2.1.3"

    const val retrofit = "2.9.0"
    const val logging_interceptor = "5.0.0-alpha.4"

    const val rxkotlin = "2.3.0"
    const val rxandroid = "2.1.0"

    const val dagger = "2.40.5"

    const val viewmodel = "2.4.1"
}

object Dependencies {
    object Android {
        const val minSdk = 21
        const val targetSdk = 32
        const val compileSdk = 32
        const val applicationId = "com.aelfattah.ahmed.appcodingtask"
        const val versionCode = 1
        const val versionName = "0.1"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object SupportLibs {
        const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gson = "com.google.code.gson:gson:${Versions.retrofit}"
        const val converter_gson =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val adapter_rxjava =
            "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
        const val logging_interceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"
    }

    object Rx {
        const val rx = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
        const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    }

    object Dagger {
        const val dagger2 = "com.google.dagger:dagger:${Versions.dagger}"
        const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

        const val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
        const val dagger_android_support =
            "com.google.dagger:dagger-android-support:${Versions.dagger}"
        const val dagger_android_processor =
            "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    }

    object JetBack {
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel}"
    }

    object TestLibs {
        const val junit = "junit:junit:4.13.2"
        const val extJunit = "androidx.test.ext:junit:1.1.3"
        const val espresso_core = "androidx.test.espresso:espresso-core:3.4.0"
    }
}