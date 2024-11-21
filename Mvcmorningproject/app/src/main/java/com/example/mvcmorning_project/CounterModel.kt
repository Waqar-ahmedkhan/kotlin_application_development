package com.example.mvcmorning_project

class CounterModel {
    private var count: Int = 0

    // method to increase the count

    fun increament(){
        count++
    }

    fun decrement(){
        count = count-1
    }

    fun reset() {
        count= 0
    }

    // methd to get the count value

    fun getCount():Int  {
        return  count
    }







}