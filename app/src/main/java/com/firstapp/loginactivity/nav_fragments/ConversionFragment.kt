package com.firstapp.loginactivity.nav_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firstapp.loginactivity.R
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class ConversionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_conversion, container, false)
        val etfn = view.findViewById<EditText>(R.id.et_firstnum)
        val spfr = view.findViewById<Spinner>(R.id.spfr)
        val spto = view.findViewById<Spinner>(R.id.spto)
        val btcvrt = view.findViewById<Button>(R.id.bt_convert)
        val disformres = view.findViewById<EditText>(R.id.etdisformares)

        val from = arrayOf("mililiters (ml)", "Liters (L)", "Ounces (Oz)", "Cups (Metric)")
        val ad = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, from)
        spfr.adapter = ad

        val to = arrayOf("mililiters (ml)", "Liters (L)", "Ounces (Oz)", "Cups (Metric)")
        val ad1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, to)
        spto.adapter = ad1

        btcvrt.setOnClickListener{
            var result: Double

            val amount = etfn.text.toString().toDoubleOrNull()

            if (spfr.selectedItem.toString() == spto.selectedItem.toString()) {
                amount?.let {
                    result = amount
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "mililiters (ml)" && spto.selectedItem.toString() == "Liters (L)") {
                amount?.let {
                    result = it / 1000
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "mililiters (ml)" && spto.selectedItem.toString() == "Cups (Metric)") {
                amount?.let {
                    result = it / 250
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "mililiters (ml)" && spto.selectedItem.toString() == "Ounces (Oz)") {
                amount?.let {
                    result = it / 29.5735
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "Liters (L)" && spto.selectedItem.toString() == "mililiters (ml)") {
                amount?.let {
                    result = it * 1000
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "Liters (L)" && spto.selectedItem.toString() == "Ounces (Oz)") {
                amount?.let {
                    result = it * 33.814
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "Liters (L)" && spto.selectedItem.toString() == "Cups (Metric)") {
                amount?.let {
                    result = it * 4.2
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "Ounces (Oz)" && spto.selectedItem.toString() == "mililiters (ml)") {
                amount?.let {
                    result = it * 29.5735
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "Ounces (Oz)" && spto.selectedItem.toString() == "Liters (L)") {
                amount?.let {
                    result = it / 33.814
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "Ounces (Oz)" && spto.selectedItem.toString() == "Cups (Metric)") {
                amount?.let {
                    result = it * .11
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "Cups (Metric)" && spto.selectedItem.toString() == "mililiters (ml)") {
                amount?.let {
                    result = it * 250
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "Cups (Metric)" && spto.selectedItem.toString() == "Ounces (Oz)") {
                amount?.let {
                    result = it * 8.45
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
            if (spfr.selectedItem.toString() == "Cups (Metric)" && spto.selectedItem.toString() == "Liters (L)") {
                amount?.let {
                    result = it * .250
                    val formattedres = String.format("%.2f", result)
                    disformres.setText(formattedres)
                }
            }
        }
        // Inflate the layout for this fragment
        return view
    }
}