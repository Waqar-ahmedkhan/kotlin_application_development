package com.example.intentsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

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
        val textMessage = findViewById<TextInputEditText>(R.id.MessageText)
        val explicitBtn = findViewById<Button>(R.id.explicitBtn);



            explicitBtn.setOnClickListener {
                val message = textMessage.editableText?.toString()
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("EXTRA_MESSAGE", message)
                }
                startActivity(intent)
        }


    }
}