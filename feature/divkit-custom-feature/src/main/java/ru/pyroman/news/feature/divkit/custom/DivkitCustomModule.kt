package ru.pyroman.news.feature.divkit.custom

import org.kodein.di.instance
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.common.core.platform.di.contextInstance
import ru.pyroman.news.feature.divkit.custom.search.SearchDivCustomViewAdapter
import ru.pyroman.news.feature.search.searchModule

val divkitCustomModule = module("divkitCustomModule") {
    importAll(
        searchModule,
    )

    provider {
        SearchDivCustomViewAdapter(
            context = contextInstance(),
            searchPresenterFactory = instance("SearchPresenterFactory"),
            divVariableController = instance(),
        )
    }

    provider<DivCustomViewAdaptersProvider> {
        DivCustomViewAdaptersProviderImpl(
            searchDivCustomViewAdapter = instance(),
        )
    }
}