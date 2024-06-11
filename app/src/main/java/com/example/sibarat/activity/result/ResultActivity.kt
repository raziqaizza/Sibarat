package com.example.sibarat.activity.result

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sibarat.activity.camera.CameraActivity
import com.example.sibarat.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setupButton()
    }

    private fun setupButton() {
        binding.btnReset.setOnClickListener {
            val resetIntent = Intent(this@ResultActivity, CameraActivity::class.java)
            startActivity(resetIntent)
            finish()
        }
    }
}