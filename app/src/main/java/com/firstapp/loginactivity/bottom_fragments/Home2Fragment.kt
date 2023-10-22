package com.firstapp.loginactivity.bottom_fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.firstapp.loginactivity.R
import com.firstapp.loginactivity.category.CateAdobo
import com.firstapp.loginactivity.category.CateSinigang
import com.firstapp.loginactivity.category.CateSisig
import com.firstapp.loginactivity.dishes.AdobosaGata
import com.firstapp.loginactivity.dishes.PorkMenudo
import com.firstapp.loginactivity.dishes.Sinigang
import com.firstapp.loginactivity.dishes.Sisig
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
        val btmenudo = view.findViewById<ImageButton>(R.id.menudo)
        btmenudo.setOnClickListener {
            onClickPorkMenudo()
        }
        val btsinigang = view.findViewById<ImageButton>(R.id.sinigang)
        btsinigang.setOnClickListener {
            onClickSinigang()
        }
        val btporksisig = view.findViewById<ImageButton>(R.id.sisig)
        btporksisig.setOnClickListener {
            onClickPorkSisig()
        }
        val catadobo = view.findViewById<ImageButton>(R.id.catadobo)
        catadobo.setOnClickListener {
            onClickCatAdobo()
        }
        val catsinigang = view.findViewById<ImageButton>(R.id.catsinigang)
        catsinigang.setOnClickListener {
            onClickCatSinigang()
        }
        val catsisig = view.findViewById<ImageButton>(R.id.catsisig)
        catsisig.setOnClickListener {
            onClickCatSisig()
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
    private fun onClickPorkMenudo() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frg_home2, PorkMenudo())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickSinigang(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frg_home2, Sinigang())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickPorkSisig(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frg_home2, Sisig())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickCatAdobo(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frg_home2, CateAdobo())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickCatSinigang(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frg_home2, CateSinigang())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickCatSisig(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frg_home2, CateSisig())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
}
