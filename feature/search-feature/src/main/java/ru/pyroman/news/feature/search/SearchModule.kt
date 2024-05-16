package ru.pyroman.news.feature.search

import org.kodein.di.instance
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.common.core.di.singleton
import ru.pyroman.news.data.search.searchDataModule
import ru.pyroman.news.domain.search.searchDomainModule
import ru.pyroman.news.feature.search.presenter.SearchPresenterFactory
import ru.pyroman.news.feature.search.usecases.SearchUseCases

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