package ru.pyroman.news.domain.search

import ru.pyroman.news.common.core.di.Inject
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.domain.search.usecase.ObserveSearchInputUseCase
import ru.pyroman.news.domain.search.usecase.SetSearchInputUseCase

val searchDomainModule = module("searchDomainModule") {

    provider {
        SetSearchInputUseCase(
            searchRepository = Inject.instance(),
        )
    }

    provider(
        tag = "ObserveSearchInputUseCase"
    ) {
        ObserveSearchInputUseCase(
            searchRepository = Inject.instance(),
        )
    }
}