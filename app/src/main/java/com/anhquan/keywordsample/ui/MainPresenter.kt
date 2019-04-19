package com.anhquan.keywordsample.ui

import com.anhquan.keywordsample.MainApplication
import com.anhquan.keywordsample.callback.GetKeywordCallback
import com.anhquan.keywordsample.di.DataInjector
import com.anhquan.keywordsample.enums.AppError
import com.anhquan.keywordsample.util.NetworkUtil

class MainPresenter(private var view: MainMvpView) {

    private val keywordRepository = DataInjector.keywordRepository

    fun onViewCreated() {
        fetchKeywordsFromServer()
    }

    private fun fetchKeywordsFromServer() {
        if (!NetworkUtil.isInternetConnected(MainApplication.instance.applicationContext)) {
            view.showErrorMessage(AppError.NETWORK_CONNECTION.description)
            view.showRetryButton()
            return
        }
        view.showLoading()
        keywordRepository.getKeywordFromServer(object : GetKeywordCallback {
            override fun onSuccess(keywordList: ArrayList<String>) {
                view.hideLoading()
                view.showKeywordList(keywordList)
            }

            override fun onFailed(error: AppError) {
                view.hideLoading()
                view.showErrorMessage(error.description)
                view.showRetryButton()
            }

        })
    }

    fun onRetryButtonClicked() {
        view.hideRetryButton()
        fetchKeywordsFromServer()
    }


}