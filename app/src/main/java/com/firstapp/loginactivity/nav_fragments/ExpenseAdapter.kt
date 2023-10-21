import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.firstapp.loginactivity.R

class ExpenseAdapter(context: Context) : ArrayAdapter<String>(context, R.layout.expense_item) {
    private val items = mutableListOf<String>()

    fun addExpense(expense: String) {
        items.add(expense)
        notifyDataSetChanged()
    }

    fun removeExpense(position: Int) {
        items.removeAt(position)
        notifyDataSetChanged()
    }

    fun editExpense(position: Int, editedExpense: String) {
        items[position] = editedExpense
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.expense_item, parent, false)
        val expenseText = view.findViewById<TextView>(R.id.expense_text)
        expenseText.text = getItem(position)
        return view
    }

    override fun getItem(position: Int): String? {
        return items[position]
    }

    override fun getCount(): Int {
        return items.size
    }
}