package com.example.tapoo

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tapoo.databinding.ActivityDetails1Binding

class DetailsActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityDetails1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetails1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       binding.trunk.setOnClickListener {
           val intent = Intent(this,DetailsActivity11::class.java)
           startActivity(intent)
       }
        binding.oyun.setOnClickListener {
            val intent = Intent(this,DetailsActivity11::class.java)
            startActivity(intent)
        }
        binding.i.setOnClickListener {
            val intent = Intent(this,Telimat::class.java)
            startActivity(intent)
        }
        binding.grupoyunu.setOnClickListener {
            val intent = Intent(this,MakeGroup::class.java)
            startActivity(intent)
        }
        binding.grupoyunu1.setOnClickListener {
            val intent = Intent(this,MakeGroup::class.java)
            startActivity(intent)
        }
        val views = listOf(binding.parametrler, binding.parametrler1, binding.parametrler2)
        views.forEach { view ->
            view.setOnClickListener {
                val intent = Intent(this@DetailsActivity1, Settings::class.java)
                startActivity(intent)
            }
        }
        val views1 = listOf(binding.addsoz, binding.addsoz1, binding.addsoz2)
        views1.forEach { view ->
            view.setOnClickListener {
                val intent = Intent(this, DetailsActivity13::class.java)
                startActivity(intent)
            }
        }
        binding.profile.setOnClickListener {
            val intent=Intent(this@DetailsActivity1, Profile::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}