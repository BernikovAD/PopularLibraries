package com.example.popularlibraries.model

class CountersModel {
    private val counters = mutableListOf(0, 0, 0)

     fun getCurrent(index: Int): Int {
        return counters[index]
    }
    fun next(index: Int): Int {
        counters[index]++
        return getCurrent(index)
    }
}