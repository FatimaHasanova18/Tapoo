package com.example.tapoo

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tapoo.databinding.ActivityDetails11Binding
import com.example.tapoo.databinding.ActivitySecondCatagoryActivitiyBinding

class SecondCatagoryActivitiy : AppCompatActivity() {
    private lateinit var binding: ActivitySecondCatagoryActivitiyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding =ActivitySecondCatagoryActivitiyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding.apply {
            val intent = Intent(this@SecondCatagoryActivitiy, DetailsActivity15::class.java)
            listOf(yemekler, heyvanlar, meshurlar, mucerred,fenler,olkeler,esyalar,qarisiq).forEach { view ->
                view.setOnClickListener {
                    startActivity(intent)
                }
            }
        }
        binding.yemekler.setOnClickListener {
            val intent =Intent(this,DetailsActivity15::class.java)
            intent.putExtra("keyword","yemekler")
            startActivity(intent)
        }
        binding.olkeler.setOnClickListener {
            val intent =Intent(this,DetailsActivity15::class.java)
            intent.putExtra("keyword","olkeler")
            startActivity(intent)
        }
        binding.meshurlar.setOnClickListener {
            val intent =Intent(this,DetailsActivity15::class.java)
            intent.putExtra("keyword","meshurlar")
            startActivity(intent)
        }
        binding.arrow.setOnClickListener {
            val intent = Intent(this,DetailsActivity1::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}