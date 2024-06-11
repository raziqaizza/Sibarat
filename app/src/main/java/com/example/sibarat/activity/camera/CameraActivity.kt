package com.example.sibarat.activity.camera

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.sibarat.R
import com.example.sibarat.activity.result.ResultActivity
import com.example.sibarat.databinding.ActivityCameraBinding
import com.example.sibarat.getImageUri

class CameraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraBinding
    private var currentImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setupButton()
    }

    private fun showImage() {
        currentImageUri?.let {
            Log.d("showImage", "$it")
            binding.ivResultPhoto.setImageURI(it)
        }
    }

    private fun deleteImage() {
        currentImageUri = null
        binding.ivResultPhoto.setImageResource(R.drawable.ic_image_placeholder)
    }

    private val launcherGallery =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri: Uri? ->
            if (uri != null) {
                currentImageUri = uri
                showImage()
            } else {
                Log.d("Photo Picker", "No media selected.")
            }
        }

    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val launcherCamera =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
            if (isSuccess) {
                showImage()
            }
        }

    private fun startCamera() {
        currentImageUri = getImageUri(this)
        launcherCamera.launch(currentImageUri)
    }

    private fun setupButton() {

        binding.btnDelete.setOnClickListener {
            deleteImage()
            showToast("Gambar berhasil dihapus.")
        }

        binding.btnGallery.setOnClickListener {
            startGallery()
        }

        binding.btnCamera.setOnClickListener {
            startCamera()
        }

        binding.btnSelesai.setOnClickListener {
            val finsihIntent = Intent(this@CameraActivity, ResultActivity::class.java)
            startActivity(finsihIntent)
            finish()
        }

        binding.btnScan.setOnClickListener {
            if (currentImageUri == null) {
                return@setOnClickListener showToast("Masukkan gambar terlebih dahulu.")
            }
            showToast("Fitur sedang dalam tahap development.")
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}