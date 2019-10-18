package com.example.bonch.dev.school.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.bonch.dev.school.R

class SecondFragment : Fragment() {
    private lateinit var backButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myFragmentView: View? = inflater.inflate(R.layout.fragment_second, container, false)
        initializeViews(myFragmentView)
        setListeners()
        return myFragmentView
    }

    private fun initializeViews(fragmentView: View?)
    {
        backButton = (fragmentView?.findViewById(R.id.back_button))!!
    }

    private fun setListeners()
    {
        backButton.setOnClickListener()
        {
            val firstFragment = FirstFragment()
            replaceFragment(firstFragment)
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