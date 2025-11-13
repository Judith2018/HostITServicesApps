package com.example.hostitservices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SupportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)

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

        // Support Ticket Submission
        val subjectInput = findViewById<EditText>(R.id.supportSubject)
        val messageInput = findViewById<EditText>(R.id.supportMessage)
        val submitButton = findViewById<Button>(R.id.supportSubmitButton)

        submitButton.setOnClickListener {
            val subject = subjectInput.text.toString().trim()
            val message = messageInput.text.toString().trim()

            if (subject.isNotEmpty() && message.isNotEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Ticket Submitted")
                    .setMessage("Your support ticket has been sent.\n\nSubject: $subject\nMessage: $message")
                    .setPositiveButton("OK", null)
                    .show()

                // Clear fields after submission
                subjectInput.text.clear()
                messageInput.text.clear()
            } else {
                Toast.makeText(this, "Please fill in both subject and message.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
