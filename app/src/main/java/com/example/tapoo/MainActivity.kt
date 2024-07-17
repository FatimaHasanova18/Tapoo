package com.example.tapoo

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.tapoo.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding.odun1.setOnClickListener {
            val intent =Intent(this,Level::class.java)
            startActivity(intent)
        }
//        val animation = AnimationUtils.loadAnimation(this, R.anim.anim)
//        val splashscreen = binding.odun1
//        splashscreen.animation = animation
//        Handler().postDelayed({
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 9000)

    }
//        supportActionBar?.hide()
//        val animation = AnimationUtils.loadAnimation(this, R.anim.anim)
//        val splashscreen = binding.odun1
//        splashscreen.animation = animation
//        Handler().postDelayed({
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 9000)

}
