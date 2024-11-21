package com.example.mvctempertureconverter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        // sample data ; List of fruits with their name and drawable resource ids

        val fruitList = listOf(
            Fruit("Apple", R.drawable.apple),
            Fruit("banana", R.drawable.banana),
            Fruit("Apple", R.drawable.apple),
            Fruit("banana", R.drawable.banana)
        )

        val recyclerView: RecyclerView = findViewById(R.id.RecycleView)

        recyclerView.layoutManager = LinearLayoutManager(this);

        val adapter = FruitAdaptor(fruitList);

        recyclerView.adapter = adapter;
    }
      }

