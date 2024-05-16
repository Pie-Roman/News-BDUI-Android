package ru.pyroman.news.feature.divkit

import com.yandex.div.core.DivCustomContainerViewAdapter
import com.yandex.div.core.downloader.DivDownloader
import com.yandex.div.core.expression.variables.DivVariableController
import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div.json.ParsingErrorLogger
import org.kodein.di.instance
import ru.pyroman.news.common.core.di.module
import ru.pyroman.news.common.core.di.provider
import ru.pyroman.news.common.core.di.singleton
import ru.pyroman.news.common.core.platform.di.contextInstance
import ru.pyroman.news.data.divkit.divkitDataModule
import ru.pyroman.news.domain.divkit.divkitDomainModule
import ru.pyroman.news.feature.divkit.configuration.DivConfigurationFactory
import ru.pyroman.news.feature.divkit.context.DivContextFactory
import ru.pyroman.news.feature.divkit.custom.DivCustomContainerViewAdapterImpl
import ru.pyroman.news.feature.divkit.divview.DivViewFactory
import ru.pyroman.news.feature.divkit.download.DivDownloaderImpl
import ru.pyroman.news.feature.divkit.imageloader.DivImageLoaderFactory
import ru.pyroman.news.feature.divkit.imageloader.GlideDivImageLoaderFactory
import ru.pyroman.news.feature.divkit.presenter.DivkitPresenterFactory
import ru.pyroman.news.feature.divkit.usecases.DivkitUseCases

val divkitModule = module("divkitModule") {
    importAll(
        divkitDomainModule,
        divkitDataModule,
    )

    provider {
        DivkitUseCases(
            getViewDataUseCase = instance()
        )
    }

    singleton(
        tag = "DivkitPresenterFactory"
    ) {
        DivkitPresenterFactory()
    }

    provider<DivImageLoaderFactory> {
        GlideDivImageLoaderFactory()
    }

    provider<DivCustomContainerViewAdapter> {
        DivCustomContainerViewAdapterImpl(
            context = contextInstance(),
            adaptersProvider = instance(),
        )
    }

    provider {
        DivConfigurationFactory(
            imageLoaderFactory = instance(),
            divDownloader = instance(),
            divCustomContainerViewAdapter = instance(),
            divVariableController = instance(),
        )
    }

    singleton {
        DivContextFactory(
            divConfigurationFactory = instance(),
            context = contextInstance(),
        )
    }

    singleton {
        DivParsingEnvironment(ParsingErrorLogger.ASSERT)
    }

    provider<DivViewFactory> {
        DivViewFactory(
            contextFactory = instance(),
            environment = instance(),
        )
    }

    provider<DivDownloader> {
        DivDownloaderImpl(
            getViewPatchDataUseCase = instance("GetViewPatchDataUseCase"),
            environment = instance(),
        )
    }

    singleton {
        DivVariableController()
    }
}