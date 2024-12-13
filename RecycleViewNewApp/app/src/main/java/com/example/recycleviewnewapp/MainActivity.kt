package com.example.recycleviewnewapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var  myRecycleView: RecyclerView
    lateinit var  newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myRecycleView = findViewById(R.id.recyclerView)


        var newImagesArry = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img1,
            R.drawable.img1,
            R.drawable.img1,
            R.drawable.img1,
            R.drawable.img1,
            R.drawable.img1,
            R.drawable.img1,

        )

        var newHeadingArray = arrayOf(
            "Just checking ",
            "just checking",
            "just checking",
            "just checking",
            "just checking",
            "just checking",
            "just checking",
            "just checking",
            "just checking",
            "just checking",
            "just checking",

        )


        // RecycyleView scrolling should be horizental or vertical
        myRecycleView.layoutManager =  LinearLayoutManager(this)

        newsArrayList = arrayListOf<News>()


        for(index in newImagesArry.indices){
            val news = News(newHeadingArray[index], newImagesArry[index]);

            newsArrayList.add(news);

        }

        myRecycleView.adapter = MyAdapter(newsArrayList, this);
    }



}