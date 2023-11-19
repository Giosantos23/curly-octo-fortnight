package com.example.remindme
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_reminder.view.textViewTitle


import android.content.Context
import android.util.Log
import android.widget.BaseAdapter
import android.widget.Switch
import android.widget.Toast
import androidx.compose.material3.AlertDialog


class ReminderAdapter(private val context: Context, private val reminderList: ArrayList<Reminder>) : BaseAdapter() {


    override fun getCount(): Int {
        return reminderList.size
    }

    override fun getItem(position: Int): Any {
        return reminderList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = convertView ?: inflater.inflate(R.layout.item_reminder, null)

        val titleTextView: TextView = view.findViewById(R.id.textViewTitle)
        val howManyTimesPerDayTextView: TextView = view.findViewById(R.id.textViewHowManyTimesPerDay)
        val switchActiveNotifications: Switch = view.findViewById(R.id.switchActiveNotifications)




        val reminder = getItem(position) as Reminder

        titleTextView.text = reminder.title
        howManyTimesPerDayTextView.text = reminder.howManyTimesPerDay.toString()
        switchActiveNotifications.isChecked = reminder.active

        //Toast.makeText(context, "message", Toast.LENGTH_SHORT).show()

        return view
    }

    fun addReminder(reminder: Reminder) {
        reminderList.add(reminder)
        notifyDataSetChanged()
    }
}