package com.example.bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.R.attr.fragment
import android.R.attr.key
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class FragmentActivity : AppCompatActivity() {
    val fragmentManager = supportFragmentManager

    class Counter (startCount: Int = 0)
    {
        var currentCount = startCount
            private set

        fun increment()
        {
            ++currentCount
        }
    }

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var textField: EditText
    private lateinit var nextActivityButton: Button
    private lateinit var attachFragmentButton: Button

    private var counter: Counter = Counter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        initializeViews()
        setListeners()
    }

    private fun initializeViews()
    {
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        textField = findViewById(R.id.text_field)
        nextActivityButton = findViewById(R.id.next_activity_button)
        attachFragmentButton = findViewById(R.id.attach_fragment_button)
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

        attachFragmentButton.setOnClickListener()
        {
            attachFragment()
        }
    }

    private fun putExtras(intent: Intent)
    {
        intent.putExtra("IS_CLICKED", indicatorButton.isClickable)
        intent.putExtra("TAP_AMOUNT", counter.currentCount)
        intent.putExtra("TEXT", textField.text)
    }


    private fun attachFragment()
    {
        val fragment = MyFragment()
        putArguments(fragment)

        fragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }

    private fun putArguments(fragment: MyFragment)
    {
        val bundle = Bundle()
        bundle.putBoolean("IS_CLICKED", indicatorButton.isClickable)
        bundle.putInt("TAP_AMOUNT", counter.currentCount)
        bundle.putCharSequence("TEXT", textField.text)
        fragment.arguments = bundle
    }
}