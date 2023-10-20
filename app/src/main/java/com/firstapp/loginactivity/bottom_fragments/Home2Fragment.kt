package com.firstapp.loginactivity.bottom_fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.firstapp.loginactivity.R
import com.firstapp.loginactivity.dishes.AdobosaGata


class Home2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home2, container, false)
        val btadobo = view.findViewById<ImageButton>(R.id.Adobo)

        btadobo.setOnClickListener{
            val newFragment = AdobosaGata()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_home2, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        // Inflate the layout for this fragment
        return view
    }
}