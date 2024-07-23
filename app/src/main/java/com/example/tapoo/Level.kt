package com.example.tapoo

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tapoo.databinding.ActivityLevelBinding


class Level : AppCompatActivity() {
    private lateinit var binding: ActivityLevelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLevelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        binding.apply {
//            val intent = Intent(this@Level, DetailsActivity12::class.java)
//            listOf(btn1, orta, cetin).forEach { view ->
//                view.setOnClickListener {
//                    startActivity(intent)
//                }
//            }
//        }
        binding.arrow.setOnClickListener {
            val intent = Intent(this,DetailsActivity11::class.java)
            startActivity(intent)
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}