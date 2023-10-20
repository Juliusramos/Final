package com.firstapp.loginactivity.nav_fragments

import android.os.Bundle
import kotlin.random.Random
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.firstapp.loginactivity.R

class DishRandomizerFragment : Fragment() {
    private lateinit var imageView: ImageView
    private lateinit var rdmButton: Button
    private lateinit var continueButton: Button
    private lateinit var foodName: TextView
    val foodItems: List<Pair<Int, String>> = listOf(
        R.drawable.adobosagata to "Adobo sa Gata",
        R.drawable.menudo to "Menudo"

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_dish_randomizer, container, false)

        imageView = root.findViewById(R.id.imageView)
        rdmButton = root.findViewById(R.id.rdmButton)
        foodName = root.findViewById(R.id.foodName)

        imageSource()

        return root
    }

    private fun imageSource() {
        rdmButton.setOnClickListener {
            val random = Random
            val randomIndex = random.nextInt(foodItems.size)
            val randomPair = foodItems[randomIndex]

            imageView.setImageResource(randomPair.first)
            foodName.text = randomPair.second
        }
    }
}



