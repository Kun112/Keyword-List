package com.anhquan.keywordsample.di

import com.anhquan.keywordsample.data.repo.KeywordRepository

object DataInjector {
    val keywordRepository by lazy { KeywordRepository() }
}