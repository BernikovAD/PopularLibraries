package com.example.popularlibraries.presenter

import com.example.popularlibraries.model.CountersModel
import com.example.popularlibraries.view.MainActivity

class MainPresenter() {
    private val model = CountersModel()
    fun counterClick(type: CounterType):String {
        return when (type) {
            CounterType.ONE -> {
                model.next(0).toString()
            }
            CounterType.TWO -> {
                model.next(1).toString()
            }
            CounterType.THREE -> {
                model.next(2).toString()
            }
        }
    }
    fun setCounters(type: CounterType):String{
        return when (type) {
            CounterType.ONE -> {
                model.getCurrent(0).toString()
            }
            CounterType.TWO -> {
                model.getCurrent(1).toString()
            }
            CounterType.THREE -> {
                model.getCurrent(2).toString()
            }
        }
    }
}

enum class CounterType {
    ONE,
    TWO,
    THREE
}