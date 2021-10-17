package com.example.popularlibraries.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.ActivityMainBinding
import com.example.popularlibraries.inteface.IMainView
import com.example.popularlibraries.presenter.CounterType
import com.example.popularlibraries.presenter.MainPresenter

class MainActivity : AppCompatActivity(), IMainView {
    lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listener = View.OnClickListener {
            val type = when (it.id) {
                R.id.btn_counter_one -> CounterType.ONE
                R.id.btn_counter_two -> CounterType.TWO
                R.id.btn_counter_three -> CounterType.THREE
                else -> throw IllegalStateException("Error")
            }
            presenter.counterClick(type)
        }
        binding.btnCounterOne.setOnClickListener(listener)
        binding.btnCounterTwo.setOnClickListener(listener)
        binding.btnCounterThree.setOnClickListener(listener)
    }
    override fun setButtonTextOne(text: String) {
        binding.btnCounterOne.text = text
    }
    override fun setButtonTextTwo(text: String) {
        binding.btnCounterTwo.text = text
    }
    override fun setButtonTextThree(text: String) {
        binding.btnCounterThree.text = text
    }
}
