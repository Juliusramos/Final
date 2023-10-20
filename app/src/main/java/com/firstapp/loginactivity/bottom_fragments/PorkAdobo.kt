package com.firstapp.loginactivity.bottom_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.firstapp.loginactivity.R

class PorkAdobo : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_porkadobo, container, false)
        val adobosagata = view.findViewById<TextView>(R.id.tv_adobosagata)
        val bulletedText = getString(R.string.bl_adobosagata)
        adobosagata.text = bulletedText
        // Inflate the layout for this fragment
        return view
    }
}