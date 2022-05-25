package com.example.loginapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.loginapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController

        setUpToolBar()
        setUpDrawerLayout()
    }

    private fun setUpToolBar() {
        this.setSupportActionBar(binding.toolBar)
        supportActionBar?.title = null
        binding.toolBar.setupWithNavController(navController, binding.drawerLayout)
    }

    private fun setUpDrawerLayout() {
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolBar, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.nav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->

            if (destination.id == R.id.nextFragment){
                binding.toolBar.visibility = View.VISIBLE
            }else{
                binding.toolBar.visibility = View.GONE
            }
        }
    }
}