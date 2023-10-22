package com.firstapp.loginactivity.bottom_fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.firstapp.loginactivity.R
import com.firstapp.loginactivity.dishes.AdobosaGata
import com.firstapp.loginactivity.dishes.Tinola


class Home2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home2, container, false)
        val btadobo = view.findViewById<ImageButton>(R.id.Adobo)
        val bttinola = view.findViewById<ImageButton>(R.id.tinola)

        Log.e("mytag","open home2 fragment")

        btadobo.setOnClickListener{
            Log.e("mytag","click bt adobo")
            val newFragment = AdobosaGata()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_home2, newFragment)
            transaction.commit()
        }
        bttinola.setOnClickListener{
            val newFragment = Tinola()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_home2, newFragment)
            transaction.commit()
        }
        // Inflate the layout for this fragment
        return view
    }
}