package com.firstapp.loginactivity.nav_fragments

import android.os.Bundle
import android.util.Log
import kotlin.random.Random
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.firstapp.loginactivity.R
import com.firstapp.loginactivity.dishes.AdoboSteak
import com.google.android.material.button.MaterialButton
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
import com.firstapp.loginactivity.dishes.Sinigang
import com.firstapp.loginactivity.dishes.SinigangBangus
import com.firstapp.loginactivity.dishes.SinigangHipon
import com.firstapp.loginactivity.dishes.Sisig
import com.firstapp.loginactivity.dishes.SisigBangus
import com.firstapp.loginactivity.dishes.SisigKapampangan
import com.firstapp.loginactivity.dishes.SisigTofu
import com.firstapp.loginactivity.dishes.Tinola


class DishRandomizerFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var rdmButton: Button
    private lateinit var continueButton: MaterialButton
    private lateinit var foodName: TextView
    private var count = 1


    val foodItems: List<Pair<Int, String>> = listOf(
        R.drawable.adobosagata to "Adobo sa Gata",
        R.drawable.batchoytagalog to "Batchoy Tagalog",
        R.drawable.chickenadobo to "Chicken Adobo",
        R.drawable.porksinigang to "Pork Sinigang",
        R.drawable.adobosteak to "Adobo Steak",
        R.drawable.bcexpress to "Bicol Express",
        R.drawable.bokchoyadobo to "BokChoy Adobo",
        R.drawable.chickencurry to "Chicken Curry",
        R.drawable.crispyshrimpadobo to "Crispy Shrimp Adobo",
        R.drawable.karekare to "KareKare",
        R.drawable.laing to "Laing",
        R.drawable.adobopork to "Pork Adobo",
        R.drawable.bistek to "Pork Bistek",
        R.drawable.giniling to "Pork Giniling",
        R.drawable.menudo to "Menudo",
        R.drawable.porksinigang to "Sinigang",
        R.drawable.sgbangus to "Sinigang na Bangus",
        R.drawable.hipon to "Sinigang na Hipon",
        R.drawable.sisigpork to "Pork Sisig",
        R.drawable.sisigbangus to "Bangus Sisig",
        R.drawable.sisigkapampanga to "Sisig Kapampangan",
        R.drawable.sisigtofu to "Tofu Sisig",
        R.drawable.tinola1 to "Tinola"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dish_randomizer, container, false)

        childFragmentManager.addOnBackStackChangedListener {
            for (i in 0 until childFragmentManager.backStackEntryCount) {
                Log.d("Fragment", childFragmentManager.getBackStackEntryAt(i).name.toString())
            }
            Log.d("Fragment", "---------------")
        }

        imageView = view.findViewById(R.id.imageView)
        rdmButton = view.findViewById(R.id.rdmButton)
        foodName = view.findViewById(R.id.foodName)
        continueButton = view.findViewById(R.id.continueButton)

        rdmButton.setOnClickListener {
            rdmButton()
        }
        continueButton.setOnClickListener {
            ctnButton()
        }
        return view
    }
    private fun rdmButton() {
            val random = Random
            val randomIndex = random.nextInt(foodItems.size)
            val randomPair = foodItems[randomIndex]
            imageView.setImageResource(randomPair.first)
            foodName.text = randomPair.second
    }

     private fun ctnButton() {
         val transaction = childFragmentManager.beginTransaction()

         when (foodItems.find { it.second == foodName.text }?.first) {
             R.drawable.adobosagata -> transaction.replace(R.id.fragment_DishRandomizer,  AdobosaGata())
             R.drawable.batchoytagalog -> transaction.replace(R.id.fragment_DishRandomizer,  BatchoyTagalog())
             R.drawable.porksinigang -> transaction.replace(R.id.fragment_DishRandomizer,  Sinigang())
             R.drawable.chickenadobo -> transaction.replace(R.id.fragment_DishRandomizer,  ChickenAdobo())
             R.drawable.adobosteak -> transaction.replace(R.id.fragment_DishRandomizer, AdoboSteak())
             R.drawable.bcexpress -> transaction.replace(R.id.fragment_DishRandomizer, BicolExpress())
             R.drawable.bokchoyadobo -> transaction.replace(R.id.fragment_DishRandomizer, BokChoyAdobo())
             R.drawable.chickencurry -> transaction.replace(R.id.fragment_DishRandomizer, ChickenCurry())
             R.drawable.crispyshrimpadobo -> transaction.replace(R.id.fragment_DishRandomizer, CrispyShrimpAdobo())
             R.drawable.karekare -> transaction.replace(R.id.fragment_DishRandomizer, KareKare())
             R.drawable.laing -> transaction.replace(R.id.fragment_DishRandomizer, Laing())
             R.drawable.adobopork -> transaction.replace(R.id.fragment_DishRandomizer, PorkAdobo())
             R.drawable.bistek -> transaction.replace(R.id.fragment_DishRandomizer, PorkBistek())
             R.drawable.giniling -> transaction.replace(R.id.fragment_DishRandomizer, PorkGiniling())
             R.drawable.sgbangus -> transaction.replace(R.id.fragment_DishRandomizer, SinigangBangus())
             R.drawable.hipon -> transaction.replace(R.id.fragment_DishRandomizer, SinigangHipon())
             R.drawable.sisigpork -> transaction.replace(R.id.fragment_DishRandomizer, Sisig())
             R.drawable.sisigbangus -> transaction.replace(R.id.fragment_DishRandomizer, SisigBangus())
             R.drawable.sisigkapampanga -> transaction.replace(R.id.fragment_DishRandomizer, SisigKapampangan())
             R.drawable.sisigtofu -> transaction.replace(R.id.fragment_DishRandomizer, SisigTofu())
             R.drawable.tinola1 -> transaction.replace(R.id.fragment_DishRandomizer, Tinola())
             else ->{}
         }
         transaction.addToBackStack("Dish Randomizer")
         transaction.commit()
     }
}








