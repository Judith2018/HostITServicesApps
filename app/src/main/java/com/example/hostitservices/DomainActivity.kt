package com.example.hostitservices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.widget.EditText
import android.widget.TextView


class DomainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_domain)

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

        // Domain Search
        val domainSearchInput = findViewById<EditText>(R.id.domainSearch)
        val searchButton = findViewById<Button>(R.id.searchDomainButton)

        searchButton.setOnClickListener {
            val domainName = domainSearchInput.text.toString().trim()
            if (domainName.isNotEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Domain Search")
                    .setMessage("Searching for \"$domainName\"...\n\nResult: $domainName is available.")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                Toast.makeText(this, "Please enter a domain name", Toast.LENGTH_SHORT).show()
            }
        }

        // Domain Transfer
        val domainTransferInput = findViewById<EditText>(R.id.domainTransfer)
        val authCodeInput = findViewById<EditText>(R.id.authCode)
        val transferButton = findViewById<Button>(R.id.transferDomainButton)

        transferButton.setOnClickListener {
            val domainName = domainTransferInput.text.toString().trim()
            val authCode = authCodeInput.text.toString().trim()

            if (domainName.isNotEmpty() && authCode.isNotEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Domain Transfer")
                    .setMessage("Transfer request for \"$domainName\" has been submitted.\nAuth Code: $authCode")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                Toast.makeText(this, "Please enter both domain and auth code", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
