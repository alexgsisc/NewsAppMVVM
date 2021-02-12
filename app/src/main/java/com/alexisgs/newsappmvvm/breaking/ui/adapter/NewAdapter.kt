package com.alexisgs.newsappmvvm.breaking.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alexisgs.newsappmvvm.breaking.data.models.Article
import com.alexisgs.newsappmvvm.databinding.ItemArticlePreviewBinding
import com.bumptech.glide.Glide

class NewAdapter : RecyclerView.Adapter<NewAdapter.ArticleViewHolder>() {



    inner class ArticleViewHolder(val previewBinding: ItemArticlePreviewBinding) :
        RecyclerView.ViewHolder(previewBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemArticleBinding =
            ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ArticleViewHolder(itemArticleBinding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        with(holder) {
            with(differ.currentList[position]) {
                Glide.with(holder.itemView.context).load(urlToImage)
                    .into(previewBinding.ivArticleImage)
                previewBinding.tvSource.text = source.name
                previewBinding.tvTitle.text = title
                previewBinding.tvDescription.text = description
                previewBinding.tvPublishedAt.text = publishedAt

                holder.itemView.setOnClickListener {
                    onItemClickListener?.let { it(this@with) }
                }

            }
        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

}