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

    object TestLibs {
        const val junit = "junit:junit:4.13.2"
        const val extJunit = "androidx.test.ext:junit:1.1.3"
        const val espresso_core = "androidx.test.espresso:espresso-core:3.4.0"
    }
}