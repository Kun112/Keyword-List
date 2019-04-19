package com.anhquan.keywordsample.data.repo

import com.anhquan.keywordsample.callback.GetKeywordCallback
import com.anhquan.keywordsample.data.remote.RetrofitClient
import com.anhquan.keywordsample.enums.AppError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class KeywordRepository {

    private val apiService by lazy { RetrofitClient().getApiService() }

    fun getKeywordFromServer(callback: GetKeywordCallback): Disposable {
        return apiService.getKeywordList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ keywordList ->
                callback.onSuccess(keywordList)
            }, {
                callback.onFailed(AppError.parse(it))
            })

    }


}