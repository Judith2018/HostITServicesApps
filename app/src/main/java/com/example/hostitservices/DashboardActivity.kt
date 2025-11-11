package com.example.hostitservices


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Navigation buttons
        val btnDomain = findViewById<Button>(R.id.btnDomain)
        val btnHosting = findViewById<Button>(R.id.btnHosting)
        val btnSupport = findViewById<Button>(R.id.btnSupport)
        val btnCart = findViewById<Button>(R.id.btnCart)

        // Navigate to Domain screen
        btnDomain.setOnClickListener {
            val intent = Intent(this, DomainActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Hosting Plans screen
        btnHosting.setOnClickListener {
            val intent = Intent(this, HostingPlansActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Support screen
        btnSupport.setOnClickListener {
            val intent = Intent(this, SupportActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Cart screen
        btnCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }


    }
}
