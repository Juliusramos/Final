package com.firstapp.loginactivity.nav_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.firstapp.loginactivity.R
class BudgetFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var totalExpense = 0.0
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var totalExpenseTextView: TextView
    private lateinit var expenseNameEditText: EditText
    private lateinit var expenseAmountEditText: EditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_budget, container, false)
        val addExpenseButton = view.findViewById<Button>(R.id.expense_button)
        val expenseListView = view.findViewById<ListView>(R.id.expense_view)
        expenseNameEditText = view.findViewById(R.id.expense_name)
        expenseAmountEditText = view.findViewById(R.id.expense_amount)
        totalExpenseTextView = view.findViewById(R.id.list_view)

        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1)
        expenseListView.adapter = adapter

        addExpenseButton.setOnClickListener {
            addExpense()
        }
        return view
    }
    private fun addExpense() {
        val expenseName = expenseNameEditText.text.toString()
        val expenseAmountStr = expenseAmountEditText.text.toString()

        if (expenseName.isNotEmpty() && expenseAmountStr.isNotEmpty()) {
            val expenseAmount = expenseAmountStr.toDouble()
            totalExpense += expenseAmount

            adapter.add("$expenseName: PHP$expenseAmount")
            expenseNameEditText.text.clear()
            expenseAmountEditText.text.clear()

            updateTotalExpense()
        }
    }

    private fun updateTotalExpense() {
        totalExpenseTextView.text =
            getString(R.string.total_expense_php, "%.2f".format(totalExpense))
    }
        // Inflate the layout for this fragment
    }