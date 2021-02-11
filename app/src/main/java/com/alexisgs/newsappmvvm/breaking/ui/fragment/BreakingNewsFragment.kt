package com.alexisgs.newsappmvvm.breaking.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexisgs.newsappmvvm.databinding.FragmentBreakingNewsBinding

/**
 *  Created by Alexis Guadarrama on 2/10/21.
 *  Noticias de Ultima hora
 */
class BreakingNewsFragment : Fragment() {

    private var _breakingNewsBinding: FragmentBreakingNewsBinding? = null

    private val breakingNewsBinding get() = _breakingNewsBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _breakingNewsBinding = FragmentBreakingNewsBinding.inflate(inflater, container, false)
        return breakingNewsBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _breakingNewsBinding = null
    }
}