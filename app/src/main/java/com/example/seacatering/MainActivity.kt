package com.example.seacatering

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.appbar.MaterialToolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.seacatering.kontak.KontakFragment
import com.example.seacatering.menu.MenuFragment
import com.example.seacatering.subscription.SubscriptionFragment
import com.example.seacatering.ui.beranda.BerandaFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    lateinit var hamburgerIcon: MaterialToolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    fun initComponents() {
        hamburgerIcon = findViewById(R.id.hamburgerIcon)
        drawerLayout = findViewById(R.id.main_layout)
        navView = findViewById(R.id.nav_view)
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initComponents()

        val mainConstraint = findViewById<View>(R.id.mainConstraint)


        replaceFragment(BerandaFragment()) // default halaman

        hamburgerIcon.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        navView.setCheckedItem(R.id.nav_home)

        navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawer(GravityCompat.START)

            when (menuItem.itemId) {
                R.id.nav_home -> {
                    replaceFragment(BerandaFragment())
                    Log.i("Jamal", "Intent: Fragment Beranda ")
                }
                R.id.nav_about -> {
                    replaceFragment(MenuFragment())
                    Log.i("Jamal", "Intent: Fragment Tentang Kami ")
                }
                R.id.nav_subscription -> {
                    replaceFragment(SubscriptionFragment())
                    Log.i("Jamal", "Intent: Fragment Subscription ")
                }
                R.id.nav_contact -> {
                    replaceFragment(KontakFragment())
                    Log.i("Jamal", "Intent: Fragment Kontak ")
                }
            }
            true
        }

    }
}
