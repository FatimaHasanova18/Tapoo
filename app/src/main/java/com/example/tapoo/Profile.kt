package com.example.tapoo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tapoo.databinding.ActivityProfileBinding

class Profile: AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private var selectedAvatarResId: Int = R.drawable.ayi // Set a default avatar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        val imageViews = listOf(
            binding.ayi, binding.pisik, binding.meymun, binding.agayi,
            binding.sincab, binding.panda, binding.tulku, binding.fil,
            binding.maral, binding.peleng, binding.dovsan, binding.zebra,
            binding.at, binding.sican, binding.pitbull
        )

        imageViews.forEach { imageView ->
            imageView.setOnClickListener {
                selectedAvatarResId = when (it.id) {
                    R.id.ayi -> R.drawable.ayi
                    R.id.meymun -> R.drawable.meymun
                    R.id.agayi -> R.drawable.agayi
                    R.id.sincab -> R.drawable.sincab
                    R.id.panda -> R.drawable.panda
                    R.id.tulku -> R.drawable.tulku
                    R.id.fil -> R.drawable.fil
                    R.id.maral -> R.drawable.maral
                    R.id.peleng -> R.drawable.peleng
                    R.id.dovsan -> R.drawable.dovsan
                    R.id.zebra -> R.drawable.zebra
                    R.id.at -> R.drawable.at
                    R.id.sican -> R.drawable.sican
                    R.id.pitbull -> R.drawable.pitbull
                    else -> R.drawable.ayi
                }
                binding.choosen.setImageResource(selectedAvatarResId)
                Profil.icon=selectedAvatarResId
                Profil.name=binding.editText.text.toString()
            }
        }

        binding.tesdiqle.setOnClickListener {
            val playerName = binding.editText.text.toString()
            val sharedPreferences = getSharedPreferences("PlayerPrefs", Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putString("PlayerName", playerName)
                putInt("AvatarResId", selectedAvatarResId)
                apply()
                val  intent =Intent(this@Profile,DetailsActivity1::class.java)
                startActivity(intent)
            }

            // Start DetailsActivity12
            val intent = Intent(this, DetailsActivity12::class.java)
            startActivity(intent)
        }
    }
}
