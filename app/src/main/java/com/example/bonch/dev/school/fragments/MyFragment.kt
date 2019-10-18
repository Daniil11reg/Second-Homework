package com.example.bonch.dev.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class MyFragment: Fragment() {
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myFragmentView = inflater.inflate(R.layout.fragment_my, container, false)
        initializeViews(myFragmentView)
        return myFragmentView
    }

    private fun initializeViews(fragmentView: View) {
        textView = fragmentView.findViewById(R.id.text_view)
        textView.text = arguments?.getBoolean("IS_CLICKED", true).toString() + "\n" + arguments?.getInt(
            "TAP_AMOUNT",
            0
        ).toString() + "\n" + arguments?.getCharSequence("TEXT").toString()
    }
}