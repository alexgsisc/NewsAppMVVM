package com.alexisgs.newsappmvvm.breaking.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.alexisgs.newsappmvvm.R
import com.alexisgs.newsappmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityBinding.root
        setContentView(view)

        //activityBinding.nameUser.text = "Alexis"

        //findNavController(@IdRes R.id.newsNavHostFragment: int)
        activityBinding.bottomNavigationView.setupWithNavController(findNavController(R.id.newsNavHostFragment))
    }
}