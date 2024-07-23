package com.example.tapoo

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tapoo.databinding.ActivitySelectionIconsBinding

class SelectionIcons : AppCompatActivity() {
    private lateinit var binding: ActivitySelectionIconsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySelectionIconsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       binding.at.setOnClickListener {
           saveIconToPreferences(R.drawable.at)
       }
        binding.ayi.setOnClickListener {
            saveIconToPreferences(R.drawable.ayi)
        }
        binding.agayi.setOnClickListener {
            saveIconToPreferences(R.drawable.agayi)
        }
        binding.fill.setOnClickListener {
            saveIconToPreferences(R.drawable.fil)
        }
        binding.meymun.setOnClickListener {
            saveIconToPreferences(R.drawable.meymun)
        }
        binding.maral.setOnClickListener {
            saveIconToPreferences(R.drawable.maral)
        }
        binding.pisik.setOnClickListener {
            saveIconToPreferences(R.drawable.it)
        }
        binding.peleng.setOnClickListener {
            saveIconToPreferences(R.drawable.peleng)
        }
        binding.sincab.setOnClickListener {
            saveIconToPreferences(R.drawable.sincab)
        }
        binding.sican.setOnClickListener {
            saveIconToPreferences(R.drawable.sican)
        }
        binding.tulku.setOnClickListener {
            saveIconToPreferences(R.drawable.tulku)
        }
        binding.panda.setOnClickListener {
            saveIconToPreferences(R.drawable.panda)
        }
        binding.pitbull.setOnClickListener {
            saveIconToPreferences(R.drawable.pitbull)
        }
        binding.dovsan.setOnClickListener {
            saveIconToPreferences(R.drawable.dovsan)
        }
        binding.zebra.setOnClickListener {
            saveIconToPreferences(R.drawable.zebra)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun saveIconToPreferences(iconResId: Int) {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("selectedIcon", iconResId)
        editor.apply()
        finish()
    }
}