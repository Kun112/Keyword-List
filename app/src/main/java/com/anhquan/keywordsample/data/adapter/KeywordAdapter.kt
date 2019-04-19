package com.anhquan.keywordsample.data.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.anhquan.keywordsample.databinding.ItemRecyclerviewBinding
import com.anhquan.keywordsample.util.StringUtil
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import com.anhquan.keywordsample.R
import java.util.*
import kotlin.collections.ArrayList


class KeywordAdapter(private var keywordList: ArrayList<String>) : RecyclerView.Adapter<KeywordAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding: ItemRecyclerviewBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_recyclerview,
            viewGroup, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return keywordList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        val keyword = keywordList[index]
        viewHolder.bind(keyword)
    }

    inner class ViewHolder(private val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(key: String) {
            binding.textKeywordItem.text = StringUtil.getTextAfterAlign(key)
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            binding.textKeywordItem.setBackgroundResource(R.drawable.background_keyword_item)
            val drawable = binding.textKeywordItem.background as GradientDrawable
            drawable.setColor(color)
        }
    }

}