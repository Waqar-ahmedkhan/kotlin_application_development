package com.example.intentsproject

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        // Handle system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up the button
        val backButton = findViewById<Button>(R.id.SecondActivityBtn)

        val message = intent.getStringExtra("EXTRA_MESSAGE")

        // Find the TextView by its ID and set the received message
        val textView: TextView = findViewById(R.id.SecondActivityText)
        textView.text = message ?: "No message received"

        backButton.setOnClickListener {
            finish() // Close the activity and return to the previous one
        }
    }
}
