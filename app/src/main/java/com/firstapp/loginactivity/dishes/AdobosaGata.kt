package com.firstapp.loginactivity.dishes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.firstapp.loginactivity.R
import com.firstapp.loginactivity.bottom_fragments.Home2Fragment

class AdobosaGata : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_adobosagata, container, false)
        val vbadobo = view.findViewById<Button>(R.id.vb_backhome)

        vbadobo.setOnClickListener{
            onClickBack()
        }
        // Inflate the layout for this fragment
        return view
    }
    private fun onClickBack() {
        parentFragmentManager.popBackStack()
    }
}