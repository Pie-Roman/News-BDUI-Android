package ru.pyroman.news.feature.search

import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.data.search.searchDataModule
import ru.pyroman.news.domain.search.searchDomainModule

val searchModule = module("searchModule") {
    importAll(
        searchDomainModule,
        searchDataModule,
    )

    provider {
        SearchUseCases(
            setSearchInputUseCase = instance(),
            observeSearchInputUseCase = instance(tag = "ObserveSearchInputUseCase"),
        )
    }

    singleton(
        tag = "SearchPresenterFactory"
    ) {
        SearchPresenterFactory()
    }
}