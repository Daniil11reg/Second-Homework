package com.example.bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bonch.dev.school.fragments.FirstFragment

class FragmentActivity : AppCompatActivity() {
    val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)
        attachFirstFragment()
    }

    private fun attachFirstFragment()
    {
        fragmentManager
            .beginTransaction()
            .add(R.id.fragment, FirstFragment())
            .commit()
    }
}
