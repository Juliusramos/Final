package com.firstapp.loginactivity.nav_fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.firstapp.loginactivity.R
import com.firstapp.loginactivity.bottom_fragments.FavFragment
import com.firstapp.loginactivity.bottom_fragments.Home2Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bottom_cat -> {
                    replaceFragment(Home2Fragment())
                    activity?.title = "Home"
                }

                R.id.bottom_fav -> {
                    replaceFragment(FavFragment())
                    activity?.title = "Favorite"
                }
            }
            true
        }
        replaceFragment(Home2Fragment())
        activity?.title = "Category"
        bottomNavigationView.selectedItemId = R.id.bottom_cat

        val addFab = view.findViewById<FloatingActionButton>(R.id.fabAddBtn)
        addFab.setOnClickListener{
            Toast.makeText(context, "Add Clicked",Toast.LENGTH_LONG).show()
        }

        return view
    }
    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottomFragment, fragment)
            .commit()
    }
}