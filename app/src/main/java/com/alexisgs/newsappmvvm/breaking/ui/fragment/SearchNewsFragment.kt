package com.alexisgs.newsappmvvm.breaking.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexisgs.newsappmvvm.breaking.ui.MainActivity
import com.alexisgs.newsappmvvm.breaking.viewmodel.NewsViewModel
import com.alexisgs.newsappmvvm.databinding.FragmentSearchNewsBinding

/**
 *  Created by Alexis Guadarrama on 2/10/21.
 */
class SearchNewsFragment : Fragment() {

    private var _fragmentSearchNewsBinding: FragmentSearchNewsBinding? = null

    private val fragmentSearchNewsBinding get() = _fragmentSearchNewsBinding!!

    lateinit var viewModel : NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentSearchNewsBinding = FragmentSearchNewsBinding.inflate(inflater, container, false)
        return fragmentSearchNewsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentSearchNewsBinding = null
    }
}