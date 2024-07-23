package com.example.tapoo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.content.pm.ActivityInfo
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tapoo.databinding.ActivitySettingsBinding

class Settings : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private var count = 0
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        enableEdgeToEdge()
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("gameSettings", Context.MODE_PRIVATE)

        binding.tedbiqxidmet.setOnClickListener {
            val intent = Intent(this, DetailsActivity12::class.java)
            startActivity(intent)
        }

        val spinner: Spinner = findViewById(R.id.spinnerZaman)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_times,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position) as String
                Log.d("Settings", "Selected item: $selectedItem")

                // Tıklanan item için işlem yap
                when (selectedItem) {
                    "30" -> handleSpinnerItemClick(30)
                    "60" -> handleSpinnerItemClick(60)
                    "90" -> handleSpinnerItemClick(90)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.imageviewplus.setOnClickListener {
            updateCount(increment = true)
        }

        binding.imageviewminus.setOnClickListener {
            updateCount(increment = false)
        }
    }

    private fun updateCount(increment: Boolean) {
        if (increment) {
            count++
        } else {
            if (count > 0) {
                count--
            }
        }
        binding.passcount.text = count.toString()
        Log.d("Settings", "Pass count updated: $count")
    }

    private fun handleSpinnerItemClick(value: Int) {
        val editor = sharedPreferences.edit()
        editor.putString("time", value.toString())
        editor.apply()
        Log.d("Settings", "Time setting saved: $value")
    }
}
