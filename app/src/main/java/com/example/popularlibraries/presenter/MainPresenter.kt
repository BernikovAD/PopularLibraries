package com.example.popularlibraries.presenter

import com.example.popularlibraries.model.CountersModel
import com.example.popularlibraries.view.MainActivity

class MainPresenter(var view: MainActivity) {
    private val model = CountersModel()
    fun counterClick(type: CounterType) {
        when (type) {
            CounterType.ONE -> {
                val nextValue = model.next(0)
                view.setButtonTextOne(nextValue.toString())
            }
            CounterType.TWO -> {
                val nextValue = model.next(1)
                view.setButtonTextTwo(nextValue.toString())
            }
            CounterType.THREE -> {
                val nextValue = model.next(2)
                view.setButtonTextThree(nextValue.toString())
            }
        }
    }
}

enum class CounterType {
    ONE,
    TWO,
    THREE
}