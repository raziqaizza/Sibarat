package com.example.sibarat

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sibarat.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButton()
    }

    private fun setupButton() {
        binding.btnHome.setOnClickListener {
            val homeIntent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(homeIntent)
            finish()
        }

        binding.btnReset.setOnClickListener {
            val resetIntent = Intent(this@ResultActivity, CameraActivity::class.java)
            startActivity(resetIntent)
            finish()
        }
    }
}