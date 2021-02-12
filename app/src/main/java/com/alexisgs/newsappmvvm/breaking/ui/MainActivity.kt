package com.alexisgs.newsappmvvm.breaking.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.alexisgs.newsappmvvm.R
import com.alexisgs.newsappmvvm.breaking.data.db.ArticleDatabase
import com.alexisgs.newsappmvvm.breaking.repository.NewsRepository
import com.alexisgs.newsappmvvm.breaking.viewmodel.NewsVieModelProviderFactory
import com.alexisgs.newsappmvvm.breaking.viewmodel.NewsViewModel
import com.alexisgs.newsappmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityBinding: ActivityMainBinding

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityBinding.root
        setContentView(view)

        val newRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsVieModelProviderFactory(newRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)

        activityBinding.bottomNavigationView.setupWithNavController(findNavController(R.id.newsNavHostFragment))
    }
}