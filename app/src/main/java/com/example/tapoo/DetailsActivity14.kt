package com.example.tapoo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tapoo.databinding.ActivityDetails14Binding

class DetailsActivity14 : AppCompatActivity() {
    private lateinit var binding: ActivityDetails14Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetails14Binding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding.tg.setOnClickListener {
            val url = "https://t.me/tapoo"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        binding.arrow.setOnClickListener {
            val intent =Intent(this,Settings::class.java)
            startActivity(intent)
        }
        binding.komekmerkezi.setOnClickListener {
            val url = "https://www.google.com/search?q=game+help+center&sca_esv=5b98f86993edd4ca&sca_upv=1&rlz=1C1JJTC_enAZ1099AZ1099&ei=_VedZv_aBOW3wPAP3ZiHkAs&ved=0ahUKEwi_zeX-5biHAxXlGxAIHV3MAbIQ4dUDCA8&uact=5&oq=game+help+center&gs_lp=Egxnd3Mtd2l6LXNlcnAiEGdhbWUgaGVscCBjZW50ZXIyBhAAGAcYHjIIEAAYBxgKGB4yBhAAGAcYHjIFEAAYgAQyBhAAGAUYHjIGEAAYBRgeMgYQABgFGB4yBhAAGAUYHjIGEAAYBRgeMgYQABgIGB5IyRRQywhYkBFwAXgBkAEAmAHSAaABjgeqAQUwLjQuMbgBA8gBAPgBAZgCBqACoAfCAgoQABiwAxjWBBhHwgINEAAYgAQYsAMYQxiKBcICBxAAGIAEGA3CAggQABgFGAcYHpgDAIgGAZAGCpIHBTEuNC4xoAeKHw&sclient=gws-wiz-serp"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        binding.face.setOnClickListener {
            val url = "https://www.facebook.com/tapoo.uz"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        binding.wp.setOnClickListener {
            val url = "https://www.figma.com/design/VMNmBSgfjR7PeFRL7ZLTWd/Tabooo?node-id=302-60&t=3OxckSk3NBoAhmJ1-0"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}