package com.example.tapoo

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tapoo.databinding.ActivityMakeGroupBinding

class MakeGroup : AppCompatActivity() {
    private lateinit var binding: ActivityMakeGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakeGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        enableEdgeToEdge()

        // Update ImageViews based on stored icons
//        updateImageViewForImg1()
//        updateImageViewForImg2()

        binding.arrow.setOnClickListener {
            val intent = Intent(this, DetailsActivity1::class.java)
            startActivity(intent)
        }

        binding.a.setOnClickListener {
            // Save current group names and navigate to SelectionIcons
//            saveGroupNames(binding.qrup1.text.toString(), binding.qrup2.text.toString())
            val intent = Intent(this, SelectionIcons::class.java)
            startActivity(intent)
        }

        binding.b.setOnClickListener {
            // Save current group names and navigate to SelectionIcons
//            saveGroupNames(binding.qrup1.text.toString(), binding.qrup2.text.toString())
            val intent = Intent(this, SelectionIcons::class.java)
            startActivity(intent)
        }

        binding.oyna.setOnClickListener {
            Toast.makeText(this,"hello", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DetailsActivity15::class.java)
            startActivity(intent)
        }

        binding.oyna1.setOnClickListener {
            val intent = Intent(this, DetailsActivity15::class.java)
            startActivity(intent)
        }

        // Load previously saved group names
//        loadGroupNames()

        // Handle window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
//        updateImageViewForImg1()
//        updateImageViewForImg2()
//        loadGroupNames()
    }

//    private fun updateImageViewForImg1() {
//        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//        val selectedIconResId = sharedPreferences.getInt("selectedIcon", R.drawable.peleng)
//        Log.d("MakeGroup", "Image 1 icon ID: $selectedIconResId")
//
//        val img1 = findViewById<ImageView>(R.id.img1)
//        img1.setImageResource(selectedIconResId)
//    }
//
//    private fun updateImageViewForImg2() {
//        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//        val selectedIconResId = sharedPreferences.getInt("selectedIcon", R.drawable.agayi)
//        Log.d("MakeGroup", "Image 2 icon ID: $selectedIconResId")
//
//        val img2 = findViewById<ImageView>(R.id.img2)
//        img2.setImageResource(selectedIconResId)
//    }

//    private fun saveGroupNames(group1Name: String, group2Name: String) {
//        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        editor.putString("group1Name", group1Name)
//        editor.putString("group2Name", group2Name)
//        editor.apply()
//    }

//    private fun loadGroupNames() {
//        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//        val group1Name = sharedPreferences.getString("group1Name", "Qrup 1")
//        val group2Name = sharedPreferences.getString("group2Name", "Qrup 2")
//
//        binding.qrup1.setText(group1Name)
//        binding.qrup2.setText(group2Name)
//    }
}
