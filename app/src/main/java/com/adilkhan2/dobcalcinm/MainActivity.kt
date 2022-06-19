package com.adilkhan2.dobcalcinm

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private  var selectDate : TextView? = null
    private  var finalDate : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDate : Button = findViewById(R.id.btnDatePicker)
        selectDate = findViewById(R.id.tvSelectedDate)
        finalDate = findViewById(R.id.tvFinalDate)
        btnDate.setOnClickListener {
            // is function ko call krenge
            // jo v hona btn click hone ke baad wo sara code whi likhenge
            // function fun onCreate ke bahar hona chahiye
            clickDatePicker() //
        }
    }
    private fun clickDatePicker()
    {
        //Toast.makeText(this, "SetListernwok", Toast.LENGTH_LONG).show()
            // java
            // ek apna calendar gui hota hai jiska ham us kr rhe hai
            val myCalender : Calendar = Calendar.getInstance()
            // year variable le lenge
            val year = myCalender.get(Calendar.YEAR)
            // month variable le lenge
            val month = myCalender.get(Calendar.MONTH)
            // days variable le lenge
            val days = myCalender.get(Calendar.DAY_OF_MONTH)
            // DatePickerDialog ek Class hai already bana hua
            // usi ke constructor ka istemaal krke ham date pick
            // krenge
            // aur usko set kr denge ondatesetlistener ka
            // istemaal krke
            DatePickerDialog(this,
               DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
                   val selected = "$dayOfMonth/${month+1}/$year"
                   selectDate?.text = selected
                       // Toast.makeText(this, "SetListernwok", Toast.LENGTH_LONG).show()
                            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                          val theDate = sdf.parse(selected)
                   // if theDate will null then it will run and our app will crash
                      theDate?.let {
                          val selectedDateInMinutes = theDate.time / 60000


                          val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                          currentDate?.let {
                              val currentDateInMinutes = currentDate.time / 60000


                              val diffDateInMinutes = currentDateInMinutes - selectedDateInMinutes
                              finalDate?.text = diffDateInMinutes.toString()
                          }
                      }

               },
                year,
                month,
                days
            ).show()
    }
}