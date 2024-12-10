package com.example.activitylifecycyle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var lifeCompatActivity: TextView
    private lateinit var navigateButton: Button

    companion object {
        private const val TAG = "MainActivityLifeCycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adjust UI for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        lifeCompatActivity = findViewById(R.id.activity1text)
        navigateButton = findViewById(R.id.activityonebtn)

        // Navigate to SecondActivity on button click
        navigateButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        logAndDisplay("onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        logAndDisplay("onRestart")
    }

    override fun onResume() {
        super.onResume()
        logAndDisplay("onResume")
    }

    override fun onPause() {
        super.onPause()
        logAndDisplay("onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        logAndDisplay("onDestroy")
    }

    private fun logAndDisplay(event: String) {
        Log.d(TAG, event) // Log the lifecycle event
        lifeCompatActivity.append("$event\n") // Update the TextView with the event
    }
}
