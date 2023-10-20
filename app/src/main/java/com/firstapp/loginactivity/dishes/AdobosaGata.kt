package com.firstapp.loginactivity.dishes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firstapp.loginactivity.R

class AdobosaGata : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_adobosagata, container, false)
//        val vbadobo = view.findViewById<Button>(R.id.vb_backhome)
//
//        vbadobo.setOnClickListener{
//            val newFragment = Home2Fragment()
//            val transaction = parentFragmentManager.beginTransaction()
//            transaction.replace(R.id.frg_home2, newFragment)
//            transaction.addToBackStack(null)
//            transaction.commit()
//        }
        // Inflate the layout for this fragment
        return view
    }
}