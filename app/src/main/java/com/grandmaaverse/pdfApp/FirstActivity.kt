package com.grandmaaverse.pdfApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grandmaaverse.pdfApp.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate (layoutInflater)
        setContentView(binding.root)

        binding.btnRead.setOnClickListener {
            val intent: Intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }


    }
}