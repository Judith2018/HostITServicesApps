package com.example.hostitservices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class HostingPlansActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hosting_plans)

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

        // Hosting Plan Layouts
        val starterPlan = findViewById<LinearLayout>(R.id.starterPlan)
        val basicPlan = findViewById<LinearLayout>(R.id.basicPlan)
        val proPlan = findViewById<LinearLayout>(R.id.proPlan)
        val businessPlan = findViewById<LinearLayout>(R.id.businessPlan)

        starterPlan.setOnClickListener { goToCart("Starter Web Hosting") }
        basicPlan.setOnClickListener { goToCart("Basic Web Hosting") }
        proPlan.setOnClickListener { goToCart("Pro Web Hosting") }
        businessPlan.setOnClickListener { goToCart("Business Web Hosting") }
    }

    // Helper function to navigate to CartActivity
    private fun goToCart(planName: String) {
        AlertDialog.Builder(this)
            .setTitle("Plan Selected")
            .setMessage("$planName has been selected.")
            .setPositiveButton("Go to Cart") { _, _ ->
                val intent = Intent(this, CartActivity::class.java)
                intent.putExtra("selectedPlan", planName)
                startActivity(intent)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
