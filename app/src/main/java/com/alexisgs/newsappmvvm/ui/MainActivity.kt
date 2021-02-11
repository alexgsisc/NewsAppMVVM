package com.alexisgs.newsappmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.alexisgs.newsappmvvm.R
import com.alexisgs.newsappmvvm.databinding.ActivityMainBinding
import okhttp3.internal.notify

class MainActivity : AppCompatActivity() {

    private lateinit var activityBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityBinding.root
        setContentView(view)

        //activityBinding.nameUser.text = "Alexis"
        val navController: NavController = findNavController(R.id.newsNavHostFragment)

        //findNavController(@IdRes R.id.newsNavHostFragment: int)
        activityBinding.bottomNavigationView.setupWithNavController(findNavController(R.id.newsNavHostFragment))
    }
}