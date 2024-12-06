package com.example.datapassfromonepagetoanotherproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val coffeeType = findViewById<EditText>(R.id.coffeeTypeInput)
        val coffeeSize = findViewById<EditText>(R.id.coffeeSizeInput)
        val ExtraCream = findViewById<EditText>(R.id.extraCreamInput)
        val orderBtn = findViewById<Button>(R.id.submitButton)

        orderBtn.setOnClickListener(){
            val name = nameInput.text.toString();
            val coffeetype = coffeeType.text.toString()
            val coffeesize = coffeeSize.text.toString()
            val extracream = ExtraCream.text.toString()

            val intent = Intent(this, Ordercoffee::class.java)
            intent.putExtra("name", name)
            intent.putExtra("coffeeType", coffeetype)
            intent.putExtra("coffeeSize", coffeesize)
            intent.putExtra("extraCream", extracream)
            startActivity(intent)
        }


    }
}