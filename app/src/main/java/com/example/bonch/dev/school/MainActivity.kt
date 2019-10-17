package com.example.bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.bonch.dev.school.models.Counter

class MainActivity : AppCompatActivity() {
    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var textField: EditText
    private lateinit var nextActivityButton: Button

    private var counter: Counter = Counter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        setListeners()
    }

    private fun initializeViews()
    {
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        textField = findViewById(R.id.text_field)
        nextActivityButton = findViewById(R.id.next_activity_button)
    }

    private fun setListeners()
    {
        indicatorButton.setOnClickListener()
        {
            indicatorButton.isClickable = false
        }

        counterButton.setOnClickListener()
        {
            counter.increment()
            counterButton.text = "${counter.currentCount}"
            textField.text
        }

        nextActivityButton.setOnClickListener()
        {
            val intent = Intent(this, SecondActivity::class.java)
            putExtras(intent)
            startActivity(intent)
        }
    }

    private fun putExtras(intent: Intent)
    {
        intent.putExtra("IS_CLICKED", indicatorButton.isClickable)
        intent.putExtra("TAP_AMOUNT", counter.currentCount)
        intent.putExtra("TEXT", textField.text)
    }
}
