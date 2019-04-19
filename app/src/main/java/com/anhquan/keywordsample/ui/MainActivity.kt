package com.anhquan.keywordsample.ui

import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.anhquan.keywordsample.R
import com.anhquan.keywordsample.data.adapter.KeywordAdapter
import com.anhquan.keywordsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainMvpView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainPresenter: MainPresenter
    private lateinit var keywordAdapter: KeywordAdapter
    private var keywordList: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_main)
        mainPresenter = MainPresenter(this)
        initComponents()
        handleEvent()
        mainPresenter.onViewCreated()

    }

    private fun initComponents() {
        keywordAdapter = KeywordAdapter(keywordList)
        binding.rvKeyword.adapter = keywordAdapter
        binding.rvKeyword.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun handleEvent() {
        binding.buttonRetry.setOnClickListener {
            mainPresenter.onRetryButtonClicked()
        }
    }

    override fun showKeywordList(keywordList: ArrayList<String>) {
        this.keywordList.clear()
        this.keywordList.addAll(keywordList)
        keywordAdapter.notifyDataSetChanged()
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    override fun showRetryButton() {
        binding.buttonRetry.visibility = View.VISIBLE
    }

    override fun hideRetryButton() {
        binding.buttonRetry.visibility = View.GONE
    }
}
