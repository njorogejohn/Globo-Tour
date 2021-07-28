package com.njoro.globotour

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.njoro.globotour.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: MaterialToolbar
    private lateinit var navController: NavController
    private lateinit var binding : ActivityMainBinding
    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.activityMainToolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_frag) as NavHostFragment
        navController = navHostFragment.navController

        //Define appBarConfiguration: connect drawerlayout with Navigation component
        val appBarConfiguration = AppBarConfiguration(navController.graph,binding.drawerLayout)

        //connect toolbar with navcontroller
        binding.activityMainToolbar.setupWithNavController(navController,appBarConfiguration)

        //connect navigationview with navcontroller
        binding.navView.setupWithNavController(navController)
    }
}