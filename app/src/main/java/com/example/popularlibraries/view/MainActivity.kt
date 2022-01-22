package com.example.popularlibraries.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.ActivityMainBinding
import com.example.popularlibraries.presenter.CounterType
import com.example.popularlibraries.presenter.MainPresenter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCounters()
        val listener = View.OnClickListener {
          when (it.id) {
                R.id.btn_counter_one -> binding.btnCounterOne.text = (presenter.counterClick(CounterType.ONE))
                R.id.btn_counter_two -> binding.btnCounterTwo.text = (presenter.counterClick(CounterType.TWO))
                R.id.btn_counter_three -> binding.btnCounterThree.text = (presenter.counterClick(CounterType.THREE))
                else -> throw IllegalStateException("Error")
            }
        }
        binding.btnCounterOne.setOnClickListener(listener)
        binding.btnCounterTwo.setOnClickListener(listener)
        binding.btnCounterThree.setOnClickListener(listener)
    }

    private fun setCounters() {
        binding.btnCounterOne.text = presenter.setCounters(CounterType.ONE)
        binding.btnCounterTwo.text = presenter.setCounters(CounterType.TWO)
        binding.btnCounterThree.text = presenter.setCounters(CounterType.THREE)
    }
}
