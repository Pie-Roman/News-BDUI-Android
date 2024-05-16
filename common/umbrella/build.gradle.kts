plugins {
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "ru.pyroman.news.common.umbrella"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    api(projects.common.core)
    api(projects.common.core.platform)
    api(projects.common.core.network)

    api(projects.base.uikit)

    api(projects.feature.divkitFeature)
    api(projects.feature.divkitCustomFeature)
}