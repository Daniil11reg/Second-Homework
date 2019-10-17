package com.example.bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.bonch.dev.school.fragments.FirstFragment
import com.example.bonch.dev.school.fragments.SecondFragment

class FragmentActivity : AppCompatActivity() {
    val fragmentManager = supportFragmentManager
    private lateinit var nextActivityButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)
        attachFirstFragment()
        initializeViews()
        setListeners()
    }

    private fun initializeViews()
    {
        nextActivityButton = findViewById(R.id.next_activity_button)
        backButton = findViewById(R.id.back_button)
    }

    private fun setListeners()
    {
        nextActivityButton.setOnClickListener()
        {
            val secondFragment = SecondFragment()
            replaceFragment(secondFragment)
        }

        backButton.setOnClickListener()
        {
            val firstFragment = FirstFragment()
            replaceFragment(firstFragment)
        }
    }

    private fun attachFirstFragment()
    {
        fragmentManager
            .beginTransaction()
            .add(R.id.fragment, FirstFragment())
            .commit()
    }


    private fun replaceFragment(replacingFragment: Fragment)
    {
        fragmentManager
            .beginTransaction()
            .add(R.id.fragment, replacingFragment)
            .addToBackStack("fragment")
            .commit()
    }
}
