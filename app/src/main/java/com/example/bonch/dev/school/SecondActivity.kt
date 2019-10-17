package com.example.bonch.dev.school

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        initializeViews()
    }

    private fun initializeViews()
    {
        textView = findViewById(R.id.text_view)
        textView.text = intent.getBooleanExtra("IS_CLICKED", false).toString() + "\n" + intent.getIntExtra("TAP_AMOUNT", 0).toString() + "\n" + intent.getCharSequenceExtra("TEXT").toString()
    }
}