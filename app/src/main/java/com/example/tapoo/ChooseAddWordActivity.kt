package com.example.tapoo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tapoo.databinding.ActivityChooseAddWordBinding

class ChooseAddWordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChooseAddWordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding =ActivityChooseAddWordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding.apply {
            val intent = Intent(this@ChooseAddWordActivity, Level::class.java)
            listOf(yemekler, heyvanlar, meshurlar, mucerred,fenler,olkeler,esyalar,qarisiq).forEach { view ->
                view.setOnClickListener {
                    startActivity(intent)
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}