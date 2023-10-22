package com.firstapp.loginactivity.category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.firstapp.loginactivity.R
import com.firstapp.loginactivity.dishes.AdoboSteak
import com.firstapp.loginactivity.dishes.AdobosaGata
import com.firstapp.loginactivity.dishes.BokChoyAdobo
import com.firstapp.loginactivity.dishes.ChickenAdobo
import com.firstapp.loginactivity.dishes.PorkAdobo

class CateAdobo : Fragment() {

    var count = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cate_adobo, container, false)
        childFragmentManager.addOnBackStackChangedListener {
            for (i in 0 until childFragmentManager.backStackEntryCount) {
                Log.d("Fragment", childFragmentManager.getBackStackEntryAt(i).name.toString())
            }
            Log.d("Fragment", "---------------")
        }

        val btadobo = view.findViewById<ImageButton>(R.id.adobopork)
        btadobo.setOnClickListener {
            onClickPorkAdobo()
        }
        val btadobochi = view.findViewById<ImageButton>(R.id.adobochicken)
        btadobochi.setOnClickListener {
            onClickChickenAdobo()
        }
        val btadobosteak = view.findViewById<ImageButton>(R.id.adobosteak)
        btadobosteak.setOnClickListener {
            onClickAdoboSteak()
        }
        val btadobogata = view.findViewById<ImageButton>(R.id.adobosagata)
        btadobogata.setOnClickListener {
            onClickAdoboGata()
        }
        val btadobobok = view.findViewById<ImageButton>(R.id.adobobokchoy)
        btadobobok.setOnClickListener {
            onClickAdoboBok()
        }
        // Inflate the layout for this fragment
        return view
    }
    private fun onClickPorkAdobo() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.cateadobo, PorkAdobo())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickChickenAdobo() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.cateadobo, ChickenAdobo())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickAdoboSteak() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.cateadobo, AdoboSteak())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickAdoboGata() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.cateadobo, AdobosaGata())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickAdoboBok() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.cateadobo, BokChoyAdobo())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
}