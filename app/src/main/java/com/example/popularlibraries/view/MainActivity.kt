package com.example.popularlibraries.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.ActivityMainBinding
import com.example.popularlibraries.inteface.IMainView
import com.example.popularlibraries.presenter.MainPresenter

class MainActivity : AppCompatActivity() ,IMainView{
    lateinit var binding:ActivityMainBinding
    private val presenter = MainPresenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listener = View.OnClickListener {
            presenter.counterClick(it.id)
        }

        binding.btnCounterOne.setOnClickListener(listener)
        binding.btnCounterTwo.setOnClickListener(listener)
        binding.btnCounterThree.setOnClickListener(listener)
    }

    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от index
    override fun setButtonText(index: Int, text: String) {
        when(index){
            0 ->  binding.btnCounterOne.text = text
            1 ->  binding.btnCounterTwo.text = text
            2 ->  binding.btnCounterThree.text = text
        }
    }
}
