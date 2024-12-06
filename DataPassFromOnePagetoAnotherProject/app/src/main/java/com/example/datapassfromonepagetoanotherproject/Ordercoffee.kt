package com.example.datapassfromonepagetoanotherproject

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ordercoffee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ordercoffee)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val summaryText = findViewById<TextView>(R.id.summaryText)

        // Retrieve data from Intent
        val name = intent.getStringExtra("name")
        val coffeeType = intent.getStringExtra("coffeeType")
        val coffeeSize = intent.getStringExtra("coffeeSize")
        val extraCream = intent.getStringExtra("extraCream")

        // Display Summary
        val summary = """
            Name: $name
            Coffee Type: $coffeeType
            Size: $coffeeSize
            Extra Cream: $extraCream
        """.trimIndent()

        summaryText.text = summary
    }
}