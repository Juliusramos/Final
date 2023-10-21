package com.firstapp.loginactivity.dishes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firstapp.loginactivity.R

class BokChoyAdobo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bok_choy_adobo, container, false)
        // Inflate the layout for this fragment
        return view
    }
}