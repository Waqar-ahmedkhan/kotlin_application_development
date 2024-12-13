package com.example.recycleviewnewapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

// when layout manager fails to find a suitable for each item
class MyAdapter(var newsArrayList: ArrayList<News>, var context: Activity): RecyclerView.Adapter<MyAdapter.MyViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_each_item, parent, false)
        return  MyViewHolder(itemView)
    }


// populate item with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        var currentItem = newsArrayList[position]
        holder.Htitle.text = currentItem.newHeading
        holder.Himage.setImageResource(currentItem.newImage)

    }

    override fun getItemCount(): Int {
       return newsArrayList.size
    }




    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var Htitle  = itemView.findViewById<TextView>(R.id.HeadingTitle)
        var Himage = itemView.findViewById<ShapeableImageView>(R.id.HImages)

    }

}


