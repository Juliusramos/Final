package com.firstapp.loginactivity.category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.firstapp.loginactivity.R
import com.firstapp.loginactivity.dishes.Sinigang
import com.firstapp.loginactivity.dishes.SinigangBangus
import com.firstapp.loginactivity.dishes.SinigangHipon

class CateSinigang : Fragment() {

    var count = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cate_sinigang, container, false)
        childFragmentManager.addOnBackStackChangedListener {
            for (i in 0 until childFragmentManager.backStackEntryCount) {
                Log.d("Fragment", childFragmentManager.getBackStackEntryAt(i).name.toString())
            }
            Log.d("Fragment", "---------------")
        }
        val btpsinigang = view.findViewById<ImageButton>(R.id.sinigangpork)
        btpsinigang.setOnClickListener{
            onClickPorkSinigang()
        }
        val btbsinigang = view.findViewById<ImageButton>(R.id.sinigangbangus)
        btbsinigang.setOnClickListener{
            onClickBangusSinigang()
        }
        val bthsinigang = view.findViewById<ImageButton>(R.id.siniganghipon)
        bthsinigang.setOnClickListener{
            onClickHiponSinigang()
        }
        // Inflate the layout for this fragment
        return view
    }
    private fun onClickPorkSinigang() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.catesinigang, Sinigang())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickBangusSinigang() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.catesinigang, SinigangBangus())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickHiponSinigang() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.catesinigang, SinigangHipon())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
}