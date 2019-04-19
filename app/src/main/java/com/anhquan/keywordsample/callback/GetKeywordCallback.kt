package com.anhquan.keywordsample.callback

import com.anhquan.keywordsample.enums.AppError

interface GetKeywordCallback{

    fun onSuccess(keywordList: ArrayList<String>)

    fun onFailed(error: AppError)
}