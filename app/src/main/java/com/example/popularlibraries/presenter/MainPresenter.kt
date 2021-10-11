package com.example.popularlibraries.presenter

import com.example.popularlibraries.R
import com.example.popularlibraries.inteface.IMainView
import com.example.popularlibraries.model.CountersModel
import com.example.popularlibraries.view.MainActivity

class MainPresenter(val view: MainActivity) {
    val model = CountersModel()

    //Архитектурная ошибка. В качестве практического задания -- исправить
    fun counterClick(id: Int){
        when(id){
            R.id.btn_counter_one -> {
                val nextValue = model.next(0)
                view.setButtonText(0, nextValue.toString())
            }
            R.id.btn_counter_two -> {
                val nextValue = model.next(1)
                view.setButtonText(1, nextValue.toString())
            }
            R.id.btn_counter_three -> {
                val nextValue = model.next(2)
                view.setButtonText(2, nextValue.toString())
            }
        }
    }
}