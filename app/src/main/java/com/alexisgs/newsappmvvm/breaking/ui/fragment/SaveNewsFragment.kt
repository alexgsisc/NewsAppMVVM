package com.alexisgs.newsappmvvm.breaking.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexisgs.newsappmvvm.breaking.ui.MainActivity
import com.alexisgs.newsappmvvm.breaking.viewmodel.NewsViewModel
import com.alexisgs.newsappmvvm.databinding.FragmentSavedNewsBinding

/**
 *  Created by Alexis Guadarrama on 2/10/21.
 */
class SaveNewsFragment : Fragment() {

    private var _fragmentSavedNewsBinding: FragmentSavedNewsBinding? = null

    private val fragmentSavedNewsBinding get() = _fragmentSavedNewsBinding!!

    lateinit var viewModel : NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentSavedNewsBinding = FragmentSavedNewsBinding.inflate(inflater, container, false)
        return fragmentSavedNewsBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentSavedNewsBinding = null
    }
}