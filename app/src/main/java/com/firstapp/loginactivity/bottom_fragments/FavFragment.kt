package com.firstapp.loginactivity.bottom_fragments

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
import com.firstapp.loginactivity.dishes.BatchoyTagalog
import com.firstapp.loginactivity.dishes.BicolExpress
import com.firstapp.loginactivity.dishes.BokChoyAdobo
import com.firstapp.loginactivity.dishes.ChickenAdobo
import com.firstapp.loginactivity.dishes.ChickenCurry
import com.firstapp.loginactivity.dishes.CrispyShrimpAdobo
import com.firstapp.loginactivity.dishes.KareKare
import com.firstapp.loginactivity.dishes.Laing
import com.firstapp.loginactivity.dishes.PorkAdobo
import com.firstapp.loginactivity.dishes.PorkBistek
import com.firstapp.loginactivity.dishes.PorkGiniling
import com.firstapp.loginactivity.dishes.PorkMenudo
import com.firstapp.loginactivity.dishes.Sinigang
import com.firstapp.loginactivity.dishes.SinigangBangus
import com.firstapp.loginactivity.dishes.SinigangHipon
import com.firstapp.loginactivity.dishes.Sisig
import com.firstapp.loginactivity.dishes.SisigBangus
import com.firstapp.loginactivity.dishes.SisigKapampangan
import com.firstapp.loginactivity.dishes.SisigTofu
import com.firstapp.loginactivity.dishes.Tinola

class FavFragment : Fragment() {

    private var count = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fav, container, false)
        childFragmentManager.addOnBackStackChangedListener {
            for (i in 0 until childFragmentManager.backStackEntryCount) {
                Log.d("Fragment", childFragmentManager.getBackStackEntryAt(i).name.toString())
            }
            Log.d("Fragment", "---------------")
        }
        // Image buttons
        val btadobo = view.findViewById<ImageButton>(R.id.Adobo)
        btadobo.setOnClickListener {
            onClickAdobosaGata()
        }
        val btadobosteak = view.findViewById<ImageButton>(R.id.adobosteak)
        btadobosteak.setOnClickListener {
            onClickAdoboSteak()
        }
        val btbatchoytagalog = view.findViewById<ImageButton>(R.id.batchoytagalog)
        btbatchoytagalog.setOnClickListener{
            onClickBatchoyTagalog()
        }
        val btbicolexpress = view.findViewById<ImageButton>(R.id.bicolexpress)
        btbicolexpress.setOnClickListener{
            onClickBicolExpress()
        }
        val btbokchoyadobo = view.findViewById<ImageButton>(R.id.bokchoyadobo)
        btbokchoyadobo.setOnClickListener{
            onClickBokChoyAdobo()
        }
        val btchickenadobo = view.findViewById<ImageButton>(R.id.chickenadobo)
        btchickenadobo.setOnClickListener{
            onClickChickenAdobo()
        }
        val btchickencurry = view.findViewById<ImageButton>(R.id.chickencurry)
        btchickencurry.setOnClickListener{
            onClickChickenCurry()
        }
        // Inflate the layout for this fragment
        val btcrispyshrimpadobo = view.findViewById<ImageButton>(R.id.crispyshrimpadobo)
        btcrispyshrimpadobo.setOnClickListener {
            onClickCrispyShrimpAdobo()
        }
        val btkarekare = view.findViewById<ImageButton>(R.id.karekare)
        btkarekare.setOnClickListener {
            onClickKareKare()
        }
        val btlaing = view.findViewById<ImageButton>(R.id.laing)
        btlaing.setOnClickListener{
            onClickLaing()
        }
        val btporkadobo = view.findViewById<ImageButton>(R.id.porkadobo)
        btporkadobo.setOnClickListener{
            onClickPorkAdobo()
        }
        val btporkbistek = view.findViewById<ImageButton>(R.id.porkbistek)
        btporkbistek.setOnClickListener{
            onClickPorkBistek()
        }
        val btporkginiling = view.findViewById<ImageButton>(R.id.porkginiling)
        btporkginiling.setOnClickListener{
            onClickPorkGiniling()
        }
        val btmenudo = view.findViewById<ImageButton>(R.id.porkmenudo)
        btmenudo.setOnClickListener{
            onClickPorkMenudo()
        }
        val btsinigang = view.findViewById<ImageButton>(R.id.sinigang)
        btsinigang.setOnClickListener{
            onClickSinigang()
        }
        val btsinigangbangus = view.findViewById<ImageButton>(R.id.sinigangbangus)
        btsinigangbangus.setOnClickListener{
            onClickSinigangBangus()
        }
        val btsiniganghipon = view.findViewById<ImageButton>(R.id.siniganghipon)
        btsiniganghipon.setOnClickListener{
            onClickSinigangHipon()
        }
        val btporksisig = view.findViewById<ImageButton>(R.id.porksisig)
        btporksisig.setOnClickListener {
            onClickPorkSisig()
        }
        val btsisigbangus = view.findViewById<ImageButton>(R.id.sisigbangus)
        btsisigbangus.setOnClickListener{
            onClickSisigBangus()
        }
        val btsisigkapampangan = view.findViewById<ImageButton>(R.id.sisigkapampangan)
        btsisigkapampangan.setOnClickListener{
            onClickSisigKampampangan()
        }
        val btsisigtofu = view.findViewById<ImageButton>(R.id.sisigtofu)
        btsisigtofu.setOnClickListener{
            onClickSisigTofu()
        }
        val bttinola = view.findViewById<ImageButton>(R.id.tinola)
        bttinola.setOnClickListener {
            onClickTinola()
        }

        return view
    }
    private fun onClickAdobosaGata() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, AdobosaGata())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickAdoboSteak(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, AdoboSteak())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickBatchoyTagalog(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, BatchoyTagalog())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickBicolExpress(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, BicolExpress())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickBokChoyAdobo(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, BokChoyAdobo())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickChickenAdobo(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, ChickenAdobo())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickChickenCurry(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, ChickenCurry())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickCrispyShrimpAdobo(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, CrispyShrimpAdobo())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickKareKare(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, KareKare())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickLaing(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, Laing())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickPorkAdobo(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, PorkAdobo())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickPorkBistek(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, PorkBistek())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickPorkGiniling(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, PorkGiniling())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickPorkMenudo(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, PorkMenudo())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickSinigang(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, Sinigang())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickSinigangBangus(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, SinigangBangus())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickSinigangHipon(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, SinigangHipon())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickPorkSisig(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, Sisig())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickSisigBangus(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, SisigBangus())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickSisigKampampangan(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, SisigKapampangan())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickSisigTofu(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, SisigTofu())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickTinola(){
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.alldishes, Tinola())
        fragmentTransaction.addToBackStack("Alldishes - ${count++}")
        fragmentTransaction.commit()
    }
}