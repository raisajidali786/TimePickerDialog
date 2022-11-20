package com.codewsa.sampletimepickerdialog

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var timeTv: TextView
    private lateinit var btnShowDialog: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeTv = findViewById(R.id.time_tv)
        btnShowDialog = findViewById(R.id.btn_show_dialog)

        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val listener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)

            timeTv.text = SimpleDateFormat("HH:mm").format(calendar.time)
        }

        btnShowDialog.setOnClickListener {
            TimePickerDialog(this, listener, hour, minute, true).show()
        }
    }
}