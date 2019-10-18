package com.example.bonch.dev.school.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.bonch.dev.school.R

class FirstFragment : Fragment() {
    private lateinit var nextActivityButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myFragmentView: View? = inflater.inflate(R.layout.fragment_first, container, false)
        initializeViews(myFragmentView)
        setListeners()
        return myFragmentView
    }

    private fun initializeViews(fragmentView: View?)
    {
        nextActivityButton = (fragmentView?.findViewById(R.id.next_activity_button))!!
    }

    private fun setListeners()
    {
        nextActivityButton.setOnClickListener()
        {
            val secondFragment = SecondFragment()
            replaceFragment(secondFragment)
        }
    }

    private fun replaceFragment(replacingFragment: Fragment)
    {
        fragmentManager!!
            .beginTransaction()
            .add(R.id.fragment, replacingFragment)
            .addToBackStack("fragment")
            .commit()
    }
}