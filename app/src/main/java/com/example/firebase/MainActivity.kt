package com.example.firebase

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    lateinit var filepath: Uri
    var req = 1

    private lateinit var btnHome: Button
    private lateinit var btnProfile: Button
    private lateinit var btnLogout: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        btnHome = findViewById(R.id.btn_home)
        btnProfile = findViewById(R.id.btn_profile)
        btnLogout = findViewById(R.id.btn_logout)

        btnHome.setOnClickListener {
            val home = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(home)
        }
        btnProfile.setOnClickListener {
            val profile = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(profile)
        }
        btnLogout.setOnClickListener {
            auth.signOut()
            Intent(this, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}