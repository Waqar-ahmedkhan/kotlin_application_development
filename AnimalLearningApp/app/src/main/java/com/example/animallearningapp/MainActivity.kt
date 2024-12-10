package com.example.animallearningapp

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var  viewPager: ViewPager2
    private lateinit var  mediaPlayer: MediaPlayer

    private val animalImages = listOf(
        R.drawable.cat,
        R.drawable.cat,
        R.drawable.cat

    )

    private  val animalSound = listOf(
        R.raw.sound

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        viewPager = findViewById(R.id.imageView)
        val adapter = AnimalAdapter(animalImages, this)
        viewPager.adapter = adapter

    }
}