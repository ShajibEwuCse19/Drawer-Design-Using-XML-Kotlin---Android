package com.shajib.drawerlayout

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_layout)

        val openDrawerView = findViewById<View>(R.id.openDrawer)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        openDrawerView.setOnClickListener {
            drawerLayout?.openDrawer(GravityCompat.START)
        }

        val dialogBuilder = AlertDialog.Builder(this)
            .setMessage("Do you want to exit the app?")
            .setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    this@MainActivity.finish()
                }
            })
            .setNegativeButton("No", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    p0?.dismiss()
                }
            })


        val navView = findViewById<NavigationView?>(R.id.navView)

        navView?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.exit ->
                {
                    dialogBuilder.show()
                    true
                }
                R.id.profile -> {
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.home -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true
            }
        }

    }
}