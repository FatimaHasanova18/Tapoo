package com.example.tapoo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tapoo.databinding.ActivityChooseLevelBinding

class ChooseLevelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChooseLevelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseLevelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

//        binding.apply {
//            val intent = Intent(this@ChooseLevelActivity, DetailsActivity1::class.java)
//            listOf(easy, medium, hard).forEach { view ->
//                view.setOnClickListener {
//                    startActivity(intent)
//                    Toast.makeText(this@ChooseLevelActivity, "Söz uğurla əlavə olundu", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
        binding.easy.setOnClickListener {
            val intent = Intent(this@ChooseLevelActivity, DetailsActivity13::class.java)
            startActivity(intent)
            Toast.makeText(this@ChooseLevelActivity, "Söz uğurla əlavə olundu", Toast.LENGTH_SHORT).show()
            println("Soz")
        }

        binding.arrow.setOnClickListener {
            val intent = Intent(this, ChooseAddWordActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
