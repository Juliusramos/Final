package com.firstapp.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.firstapp.loginactivity.bottom_fragments.Home2Fragment
import com.firstapp.loginactivity.nav_fragments.AboutFragment
import com.firstapp.loginactivity.nav_fragments.BudgetFragment
import com.firstapp.loginactivity.nav_fragments.ConversionFragment
import com.firstapp.loginactivity.nav_fragments.DishRandomizerFragment
import com.firstapp.loginactivity.nav_fragments.FridgeFragment
import com.firstapp.loginactivity.nav_fragments.HomeFragment
import com.firstapp.loginactivity.nav_fragments.LagoutFragment
import com.firstapp.loginactivity.nav_fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val onBackPressedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            onBackPressedMethod()
        }
    }

    private fun onBackPressedMethod() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            finish()
        }
    }

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this,onBackPressedCallback)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)

        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        val header = navigationView.getHeaderView(0)
        val text = header.findViewById<TextView>(R.id.text)
        val logo = header.findViewById<ImageView>(R.id.logo)

        navigationView.setNavigationItemSelectedListener(this)


        val toggle = ActionBarDrawerToggle(
            this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        replaceFragment(HomeFragment())
        navigationView.setCheckedItem(R.id.nav_home)

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navFrame,fragment)
            .commit()


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> {
                replaceFragment(HomeFragment())
            }
            R.id.nav_conversion_tool -> {
                replaceFragment(ConversionFragment())
                title = "Conversion Tool"
            }
            R.id.nav_budget_tracking -> {
                replaceFragment(BudgetFragment())
                title = "Budget Tracking"
            }
            R.id.nav_dish_randomizer -> {
                replaceFragment(DishRandomizerFragment())
                title = "Dish Randomizer"
            }
            R.id.nav_fridge -> {
                replaceFragment(FridgeFragment())
                title = "Fridge"
            }
            R.id.nav_profile -> {
                replaceFragment(ProfileFragment())
                title = "Profile"
            }
            R.id.nav_about -> {
                replaceFragment(AboutFragment())
                title = "About Us"
            }
            R.id.nav_logout -> {
                replaceFragment(LagoutFragment())
                Toast.makeText( this,"Logout Clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SingInActivity::class.java)
                startActivity(intent)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}