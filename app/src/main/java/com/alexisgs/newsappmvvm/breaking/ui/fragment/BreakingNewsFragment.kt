package com.alexisgs.newsappmvvm.breaking.ui.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexisgs.newsappmvvm.breaking.ui.MainActivity
import com.alexisgs.newsappmvvm.breaking.ui.adapter.NewAdapter
import com.alexisgs.newsappmvvm.breaking.viewmodel.NewsViewModel
import com.alexisgs.newsappmvvm.databinding.FragmentBreakingNewsBinding
import com.alexisgs.newsappmvvm.utils.Resource
import java.util.logging.Logger

/**
 *  Created by Alexis Guadarrama on 2/10/21.
 *  Noticias de Ultima hora
 */
class BreakingNewsFragment : Fragment() {

    private var _breakingNewsBinding: FragmentBreakingNewsBinding? = null

    private val breakingNewsBinding get() = _breakingNewsBinding!!

    lateinit var viewModel: NewsViewModel

    lateinit var newsAdapter: NewAdapter

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
        viewModel = (activity as MainActivity).viewModel

        setupRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        onError(it)

                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }

        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _breakingNewsBinding = null
    }

    private fun setupRecyclerView() {
        newsAdapter = NewAdapter()
        breakingNewsBinding.rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun hideProgressBar() {
        breakingNewsBinding.pogressBarPagination.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        breakingNewsBinding.pogressBarPagination.visibility = View.INVISIBLE
    }

    private fun onError(title: String) {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        dialogBuilder.setMessage(title)
            .setCancelable(false)
            .setPositiveButton("Aceptar") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }

        val alert = dialogBuilder.create()
        alert.setTitle("News App")
        alert.show()
    }
}