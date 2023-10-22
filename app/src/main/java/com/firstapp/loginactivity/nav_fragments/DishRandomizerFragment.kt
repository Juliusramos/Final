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
import androidx.navigation.Navigation
import com.firstapp.loginactivity.R
import com.google.android.material.button.MaterialButton
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.firstapp.loginactivity.dishes.AdobosaGata
import com.firstapp.loginactivity.dishes.BatchoyTagalog
import com.firstapp.loginactivity.dishes.ChickenAdobo
import com.firstapp.loginactivity.dishes.Sinigang


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
        R.drawable.porksinigang to "Pork Sinigang"
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
                 else ->{}
         }
         transaction.addToBackStack("Dish Randomizer")
         transaction.commit()
     }
}








