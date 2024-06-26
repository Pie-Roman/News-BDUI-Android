package ru.pyroman.news.feature.divkit.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.pyroman.news.base.uikit.mvp.MvpDelegate.Companion.mvpDelegate
import ru.pyroman.news.base.uikit.mvp.MvpFragment
import ru.pyroman.news.base.uikit.utils.parcelableArg
import ru.pyroman.news.common.core.di.Inject.instance
import ru.pyroman.news.domain.divkit.model.ViewData
import ru.pyroman.news.feature.divkit.databinding.FragmentDivkitBinding
import ru.pyroman.news.feature.divkit.divview.DivViewFactory
import ru.pyroman.news.feature.divkit.presenter.DivkitPresenterFactory

class DivkitFragment : MvpFragment(), DivkitMvpView {

    override val mvpDelegate = mvpDelegate {
        divkitPresenterFactory.create(
            viewArgs = args,
        )
    }

    private var _binding: FragmentDivkitBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    private val divViewFactory: DivViewFactory = instance()

    private val divkitPresenterFactory: DivkitPresenterFactory = instance("DivkitPresenterFactory")

    private val args by parcelableArg<DivkitViewArgs>(ARGUMENTS)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDivkitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showView(viewData: ViewData) {
        val divView = divViewFactory.create(
            rawDivData = viewData.rawDivData,
        )

        with(binding) {
            rootView.removeAllViews()
            rootView.addView(divView)
        }
    }

    override fun showLoading() {

    }

    override fun showError() {

    }

    override fun showNetworkError() {

    }

    companion object {
        private const val ARGUMENTS = "arguments"

        fun withArgs(viewArgs: DivkitViewArgs): Bundle {
            return Bundle().apply {
                putParcelable(ARGUMENTS, viewArgs)
            }
        }
    }
}