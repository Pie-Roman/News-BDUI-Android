package ru.pyroman.news.domain.divkit

import org.kodein.di.instance
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.domain.divkit.usecase.GetViewDataUseCase
import ru.pyroman.news.domain.divkit.usecase.GetViewPatchDataUseCase

val divkitDomainModule = module("divkitDomainModule") {

    provider {
        GetViewDataUseCase(
            divkitRepository = instance(),
        )
    }

    provider(
        tag = "GetViewPatchDataUseCase",
    ) {
        GetViewPatchDataUseCase(
            divkitRepository = instance(),
        )
    }
}