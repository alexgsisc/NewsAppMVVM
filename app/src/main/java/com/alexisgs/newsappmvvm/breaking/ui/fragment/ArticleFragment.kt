package com.alexisgs.newsappmvvm.breaking.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexisgs.newsappmvvm.databinding.FragmentArticleBinding

/**
 *  Created by Alexis Guadarrama on 2/10/21.
 */
class ArticleFragment : Fragment() {

    private var _fragmentArticleBinding: FragmentArticleBinding? = null

    private val fragmentArticleBinding get() = _fragmentArticleBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentArticleBinding = FragmentArticleBinding.inflate(inflater, container, false)
        return fragmentArticleBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentArticleBinding = null
    }
}