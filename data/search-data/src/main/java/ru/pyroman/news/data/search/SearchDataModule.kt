package ru.pyroman.news.data.search

import org.kodein.di.instance
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.common.core.di.singleton
import ru.pyroman.news.data.search.datasource.cache.SearchCacheDataSource
import ru.pyroman.news.data.search.repository.SearchRepositoryImpl
import ru.pyroman.news.domain.search.repository.SearchRepository

val searchDataModule = module("searchDataModule") {

    singleton {
        SearchCacheDataSource()
    }

    provider<SearchRepository> {
        SearchRepositoryImpl(
            cacheDataSource = instance(),
        )
    }
}