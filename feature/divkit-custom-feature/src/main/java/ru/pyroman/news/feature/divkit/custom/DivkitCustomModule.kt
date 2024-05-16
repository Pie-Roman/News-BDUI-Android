package ru.pyroman.news.feature.divkit.custom

import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider

val divkitCustomModule = module("divkitCustomModule") {
    provider<DivCustomViewAdaptersProvider> {
        DivCustomViewAdaptersProviderImpl(

        )
    }
}