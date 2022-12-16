package com.example.shogiproject.model.types

enum class Direction(private val dirVal: Int) {

    BOTTOM(1),

    TOP(-1);

    fun getValueOfDirection(): Int {
        return dirVal
    }

}