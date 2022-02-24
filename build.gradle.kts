// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version Versions.BuildPlugins.application apply false
    id ("com.android.library") version Versions.BuildPlugins.library apply false
    id ("org.jetbrains.kotlin.android") version Versions.BuildPlugins.kotlin apply false
}

tasks.register(name= "type",type= Delete::class){
    delete (rootProject.buildDir)
}