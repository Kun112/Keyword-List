package com.anhquan.keywordsample.ui

interface MainMvpView {

    fun showLoading()

    fun hideLoading()

    fun showKeywordList(keywordList: ArrayList<String>)

    fun showErrorMessage(error: String)

    fun showRetryButton()

    fun hideRetryButton()
}