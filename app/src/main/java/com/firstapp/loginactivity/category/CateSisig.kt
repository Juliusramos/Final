package com.firstapp.loginactivity.category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.firstapp.loginactivity.R
import com.firstapp.loginactivity.dishes.Sisig
import com.firstapp.loginactivity.dishes.SisigBangus
import com.firstapp.loginactivity.dishes.SisigKapampangan
import com.firstapp.loginactivity.dishes.SisigTofu

class CateSisig : Fragment() {

    var count = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cate_sisig, container, false)
        childFragmentManager.addOnBackStackChangedListener {
            for (i in 0 until childFragmentManager.backStackEntryCount) {
                Log.d("Fragment", childFragmentManager.getBackStackEntryAt(i).name.toString())
            }
            Log.d("Fragment", "---------------")


        }
        val btpsisig = view.findViewById<ImageButton>(R.id.sisigpork)
        btpsisig.setOnClickListener{
            onClickPorkSisig()
        }
        val btbsisig = view.findViewById<ImageButton>(R.id.sisigbangus)
        btbsisig.setOnClickListener{
            onClickSisigBangus()
        }
        val btksisig = view.findViewById<ImageButton>(R.id.sisigkapampangan)
        btksisig.setOnClickListener{
            onClickSisigKapampangan()
        }
        val bttsisig = view.findViewById<ImageButton>(R.id.sisigtofu)
        bttsisig.setOnClickListener{
            onClickSisigTofu()
        }
        // Inflate the layout for this fragment
        return view
    }
    private fun onClickPorkSisig() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.catesisig, Sisig())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickSisigBangus() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.catesisig, SisigBangus())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickSisigKapampangan() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.catesisig, SisigKapampangan())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
    private fun onClickSisigTofu() {
        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.catesisig, SisigTofu())
        fragmentTransaction.addToBackStack("Home - ${count++}")
        fragmentTransaction.commit()
    }
}