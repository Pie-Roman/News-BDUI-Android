plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "ru.pyroman.news.android"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.pyroman.news.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
}