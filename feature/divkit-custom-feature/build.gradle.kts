plugins {
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "ru.pyroman.news.feature.divkit.custom"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(projects.base.uikit)
    implementation(projects.common.core)

    implementation(projects.feature.divkitFeature)

    implementation(libs.divkit.div)
    implementation(libs.divkit.core)
    implementation(libs.divkit.json)
}