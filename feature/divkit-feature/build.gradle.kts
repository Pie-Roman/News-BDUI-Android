plugins {
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinParcelize)
}

android {
    namespace = "ru.pyroman.news.feature.divkit"
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

    implementation(projects.domain.divkitDomain)
    implementation(projects.data.divkitData)

    implementation(libs.divkit.div)
    implementation(libs.divkit.core)
    implementation(libs.divkit.json)

    implementation(libs.glide)
}