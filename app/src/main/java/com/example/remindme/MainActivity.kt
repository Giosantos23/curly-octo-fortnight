package com.example.remindme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ListView
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private val reminders = ArrayList<Reminder>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.listView)
        val editText = findViewById<EditText>(R.id.editText)
        val editTimesPerDay = findViewById<EditText>(R.id.editTimesPerDay)
        //val e = findViewById<EditText>(R.id.editTimesPerDay)
        //val editTimesPerDayNumber = findViewById<EditText>(R.id.editTimesPerDay)
        val addButton = findViewById<Button>(R.id.addButton)

        val adapter = ReminderAdapter(this, reminders)
        listView.adapter = adapter

        addButton.setOnClickListener {
            val id : Long = Random.nextLong()
            val reminderText = editText.text.toString()
            val reminderTimesPerDay = Integer.parseInt(editTimesPerDay.text.toString())

            val howManyTimesPerDay : Int = 5
            val active : Boolean = true
            val temporalNewReminderObject : Reminder = Reminder(id, reminderText, reminderTimesPerDay, active)
            if (reminderText.isNotEmpty() && reminderTimesPerDay > 0 ) {

                adapter.addReminder(temporalNewReminderObject)
                adapter.notifyDataSetChanged()
                editText.text.clear()
                editTimesPerDay.text.clear()
                //LoginScreen()
            }
        }
    }
}
