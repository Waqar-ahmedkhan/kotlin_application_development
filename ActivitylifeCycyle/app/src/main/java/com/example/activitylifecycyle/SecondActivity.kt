package com.example.activitylifecycyle

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

class SecondActivity : AppCompatActivity() {

    private lateinit var secondActivityTextView: TextView
    private lateinit var secondActivityButton: Button

    companion object {
        private const val TAG = "SecondActivityLifeCycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        secondActivityTextView = findViewById(R.id.SecondActivityTextView)
        secondActivityButton = findViewById(R.id.SecondActivitybtn)

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

    private fun logAndDisplay(event: String) {
        Log.d(TAG, event) // Log the lifecycle event
        secondActivityTextView.append("$event\n") // Update the TextView
    }
}
