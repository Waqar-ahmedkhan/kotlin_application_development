package com.example.animallearningapp

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private val animalImages: Any, mainActivity: MainActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class Viewholder(itemView:  View): RecyclerView.ViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.activity_item_animal), parent,
    }



}
