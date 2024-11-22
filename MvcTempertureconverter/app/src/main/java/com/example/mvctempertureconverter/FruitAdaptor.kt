package com.example.mvctempertureconverter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class FruitAdaptor(fruitList: List<Fruit>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class FruitViewHolder(view: View): RecyclerView.ViewHolder(view){
        val fruitImageView: ImageView = view.findViewByID(R.id.fruitImageView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_fruit, parent, false);
        return  FruitViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  fruitList.size;

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitNameTextView.text = view.fruitName
        holder.fruitImageView.setImageRecource(fruit.imageRecourseID)
    }

}
