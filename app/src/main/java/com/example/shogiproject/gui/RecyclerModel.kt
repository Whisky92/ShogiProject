package com.example.shogiproject.gui

class RecyclerModel(dogName: String, catName: String, personName: String) {
    var dogName: String
    var catName: String
    var personName: String

    init {
        this.dogName = dogName
        this.catName = catName
        this.personName = personName
    }

    fun dogNameGet(): String {
        return this.dogName
    }

    fun catNameGet(): String {
        return this.catName
    }

    fun personNameGet(): String {
        return this.personName
    }


}