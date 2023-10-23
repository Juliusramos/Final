package com.firstapp.loginactivity.nav_fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.firstapp.loginactivity.R


class BudgetFragment : Fragment() {
    private var totalExpense = 0.0
    private lateinit var adapter: ExpenseAdapter
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

        adapter = ExpenseAdapter(requireContext())
        expenseListView.adapter = adapter

        registerForContextMenu(expenseListView)

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

            val expenseText = "$expenseName: PHP$expenseAmount"
            adapter.addExpense(expenseText)
            expenseNameEditText.text.clear()
            expenseAmountEditText.text.clear()

            updateTotalExpense()
        }
    }

    private fun updateTotalExpense() {
        totalExpenseTextView.text =
            getString(R.string.total_expense_php, "%.2f".format(totalExpense))
    }
    private fun showEditExpenseDialog(position: Int) {
        val expenseText = adapter.getItem(position)
        val dialog = AlertDialog.Builder(requireContext())
        val dialogView = layoutInflater.inflate(R.layout.edit_expense_dialog, null)
        val editedExpenseNameEditText = dialogView.findViewById<EditText>(R.id.edited_expense_name)
        val editedExpenseAmountEditText = dialogView.findViewById<EditText>(R.id.edited_expense_amount)

        val parts = expenseText!!.split(": PHP")
        editedExpenseNameEditText.setText(parts[0].trim())
        editedExpenseAmountEditText.setText(parts[1].trim())

        dialog.setView(dialogView)
        dialog.setPositiveButton("Save") { _, _ ->
            val editedExpenseName = editedExpenseNameEditText.text.toString()
            val editedExpenseAmountStr = editedExpenseAmountEditText.text.toString()
            if (editedExpenseName.isNotEmpty() && editedExpenseAmountStr.isNotEmpty()) {
                val editedExpenseAmount = editedExpenseAmountStr.toDouble()

                // Calculate the difference between the old and new expense amount
                val oldExpenseAmount = getAmountFromExpenseText(expenseText.toString())
                val expenseAmountDifference = editedExpenseAmount - oldExpenseAmount

                // Update the item in the adapter
                val editedExpenseText = "$editedExpenseName: PHP$editedExpenseAmount"
                adapter.editExpense(position, editedExpenseText)

                // Update the total expense by adding the difference
                totalExpense += expenseAmountDifference
                updateTotalExpense()
            }
        }
        dialog.setNegativeButton("Cancel") { _, _ -> }
        dialog.show()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = requireActivity().menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val position = info.position

        when (item.itemId) {
            R.id.edit -> {
                showEditExpenseDialog(position) // Open the edit dialog
                return true
            }
            R.id.delete -> {
                val removedExpense = adapter.getItem(position)
                val expenseAmount = getAmountFromExpenseText(removedExpense.toString())
                totalExpense -= expenseAmount
                adapter.removeExpense(position)
                updateTotalExpense()
                return true
            }
            else -> return super.onContextItemSelected(item)
        }


    }

    // Extract expense amount from the expense text
    private fun getAmountFromExpenseText(expenseText: String): Double {
        val parts = expenseText.split("PHP")
        return parts.last().trim().toDouble()
    }
}