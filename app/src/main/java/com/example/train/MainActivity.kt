package com.example.train

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView : TextView = findViewById(R.id.txtCountTime)

        lifecycleScope.launch {
            viewModel.countDownFLow.collect{
                textView.text = it.toString()
            }
        }
    }



    fun main() = runBlocking {
        val numbersFlow = flow {
            for (i in 1..10) {
                delay(100)
                emit(i)
            }
        }

        numbersFlow
            .filter { it % 2 == 0 }
            .map { it * it }
            .onEach { println("Mapped value: $it") }
            .collect { value ->
                println("Final value: $value")
            }
    }
}