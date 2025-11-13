package com.example.hostitservices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Get selected plan from HostingPlansActivity
        val selectedPlan = intent.getStringExtra("selectedPlan")

        // Reference to cartTextView
        val cartTextView = findViewById<TextView>(R.id.cartTextView)

        if (selectedPlan != null) {
            cartTextView.text = "You have added: $selectedPlan"
        } else {
            cartTextView.text = "Your cart is empty."
        }

        // Checkout button
        val checkoutButton = findViewById<Button>(R.id.checkoutButton)
        checkoutButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Checkout")
                .setMessage("Proceeding to checkout for: $selectedPlan")
                .setPositiveButton("OK", null)
                .show()
        }

        // Back to Dashboard
        val backButton = findViewById<Button>(R.id.btnBackToDashboard)
        backButton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }

        // Logout
        val logoutButton = findViewById<Button>(R.id.btnLogout)
        logoutButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to log out?")
                .setPositiveButton("Yes") { _, _ ->
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
    }
}
