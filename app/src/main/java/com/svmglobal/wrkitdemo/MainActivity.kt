package com.svmglobal.wrkitdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.svmglobal.wrkitdemo.ui.offers.OffersViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: OffersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)

        viewModel =
            ViewModelProviders.of(this)
                .get(OffersViewModel::class.java)

    }
}
