package com.example.bottomnavigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var selectedFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNav.setOnItemSelectedListener {
            // using item's ids change fragments
            when (it.itemId) {
                R.id.home -> { selectedFragment = HomeFragment() }
                R.id.createPost -> { selectedFragment = NewPostFragment() }
                R.id.Profile -> { selectedFragment = ProfileFragment() }
            }
            // replace one fragment to another
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit()
            true
        }

// set the default fragment to show
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
    }
}