package com.example.mvcmorning_project

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

        val counterModel = CounterModel();

        // Get the reference of the  UI elemnts
        val countTextView = findViewById<TextView>(R.id.CountText)
        val increamentbtn = findViewById<Button>(R.id.IncrementBtn);
        val decrementbtn  = findViewById<Button>(R.id.DecrementBtn);
        val resetVal = findViewById<Button>(R.id.resetCount);

        increamentbtn.setOnClickListener{
            counterModel.increament()
            countTextView.text = counterModel.getCount().toString();
        }
        decrementbtn.setOnClickListener{
            counterModel.decrement();
            countTextView.text = counterModel.getCount().toString();
        }
        resetVal.setOnClickListener{
            counterModel.reset();
            countTextView.text = counterModel.getCount().toString();
        }
    }
}