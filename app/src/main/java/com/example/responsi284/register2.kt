package com.example.responsi284


import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.responsi284.R
import kotlinx.android.synthetic.main.register1.*
import java.text.SimpleDateFormat
import java.util.*

class register : AppCompatActivity() {
    var edDate: EditText? = null
    @RequiresApi(Build.VERSION_CODES.N)
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register1)

        edDate = this.register_tanggalLahir

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            @RequiresApi(Build.VERSION_CODES.N)
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()

            }
        }

        edDate!!.setOnClickListener(object : View.OnClickListener {
            @RequiresApi(Build.VERSION_CODES.N)
            override fun onClick(view: View) {
                DatePickerDialog(
                    this@register, dateSetListener,

                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        })

        button_register.setOnClickListener() {
            var nama2 = register_nama.text.toString()
            var alamat2 = register_alamat.text.toString()
            var tgl_lhr = register_tanggalLahir.text.toString()
            var tmp_lhr = tempatLahir.text.toString()
            intent = Intent(this, preview::class.java)
            intent.putExtra("nama2", nama2)
            intent.putExtra("alamat2", alamat2)
            intent.putExtra("tgl_lhr", tgl_lhr)
            intent.putExtra("tmp_lhr", tmp_lhr)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)

        edDate!!.setText(sdf.format(cal.getTime()))

        fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.register1)

            val bundle: Bundle? = intent.extras
            val id = bundle?.get("id_value")
            val language = bundle?.get("language_value")
            Toast.makeText(applicationContext, id.toString() + "" + language, Toast.LENGTH_LONG)
                .show()
            button_register.setOnClickListener() {
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}