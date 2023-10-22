package com.firstapp.loginactivity.bottom_fragments

import android.content.Context
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

    private var count = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home2, container, false)
        Log.e("mytag", "open home2 fragment")

        childFragmentManager.addOnBackStackChangedListener {
            for (i in 0 until childFragmentManager.backStackEntryCount) {
                Log.d("Fragment", childFragmentManager.getBackStackEntryAt(i).name.toString())
            }
            Log.d("Fragment", "---------------")
        }

        val btadobo = view.findViewById<ImageButton>(R.id.Adobo)
        btadobo.setOnClickListener {
            onClickPorkAdobo()
        }
        val bttinola = view.findViewById<ImageButton>(R.id.tinola)
        bttinola.setOnClickListener{
            onClickTinola()
        }
        // Inflate the layout for this fragment
        return view
    }

    private fun onClickPorkAdobo() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frg_home2, AdobosaGata())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickTinola() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frg_home2, Tinola())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
}
