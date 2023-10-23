package com.firstapp.loginactivity.nav_fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.firstapp.loginactivity.R
import kotlin.random.Random

class DishRandomizerFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var rdmButton: Button
    private lateinit var foodName: TextView

    val foodImages: IntArray = intArrayOf(
        R.drawable.adobochicken,
        R.drawable.adobopork,
        R.drawable.sisigpork

    )
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_dish_randomizer, container, false)

        imageView = root.findViewById(R.id.imageView)
        rdmButton = root.findViewById(R.id.rdmButton)

        imageSource()

        return root
    }

    private fun imageSource() {
        rdmButton.setOnClickListener {
            val random = Random
            val randomImageResource = foodImages[random.nextInt(foodImages.size)]
            imageView.setImageResource(randomImageResource)
        }
    }

}
