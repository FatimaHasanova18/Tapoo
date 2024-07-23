package com.example.tapoo

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tapoo.databinding.ActivityDetails13Binding

class DetailsActivity13 : AppCompatActivity() {
    private lateinit var binding: ActivityDetails13Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetails13Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ok1.setOnClickListener {
        val intent =Intent(this@DetailsActivity13,ChooseAddWordActivity::class.java)
            startActivity(intent)

        }
        binding.ok2.setOnClickListener {
            val intent =Intent(this,ChooseAddWordActivity::class.java)
            startActivity(intent)
        }
        binding.arrow.setOnClickListener {
            val intent = Intent(this@DetailsActivity13, DetailsActivity1::class.java)
            startActivity(intent)
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

    }
}