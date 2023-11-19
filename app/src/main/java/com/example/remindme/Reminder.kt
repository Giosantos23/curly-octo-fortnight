package com.example.remindme

import android.net.Uri

data class Reminder(
    val id: Long,
    val title: String,// An ID to uniquely identify the task // The description of the task
    var howManyTimesPerDay: Int,
    var active : Boolean)




