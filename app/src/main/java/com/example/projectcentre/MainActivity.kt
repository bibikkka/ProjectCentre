package com.example.projectcentre

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updateLayoutParams
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.projectcentre.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment

        navController = navHostFragment.findNavController()

        val valueInPixels =
            resources.getDimension(R.dimen.marginFragment).roundToInt()

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.projectsFragment, R.id.navigation_notifications, R.id.navigation_person
            ),

            )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.mainPage -> {
                    binding.navView.visibility = View.VISIBLE
                    (this as AppCompatActivity).supportActionBar!!.show()
                    binding.navHostFragmentActivityMain.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                        setMargins(0, 0, 0, valueInPixels)
                    }
                }
//                R.id.addProject, R.id.detailFragment, R.id.taskDetail, R.id.addTask -> {
//                    (this as AppCompatActivity).supportActionBar!!.show()
//                    binding.navView.visibility = View.GONE
//                    binding.navHostFragmentActivityMain.updateLayoutParams<ViewGroup.MarginLayoutParams> {
//                        setMargins(0, 0, 0, 0)
//                    }
//                }
                else -> {
                    (this as AppCompatActivity).supportActionBar!!.hide()
                    binding.navView.visibility = View.GONE
                    binding.navHostFragmentActivityMain.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                        setMargins(0, 0, 0, 0)
                    }
                }
            }

            navView.setupWithNavController(navController)
        }

        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
//            R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_person -> {
//                navController.navigate(item.itemId)
//            }
        }
        return true
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment_activity_main).navigateUp()
}