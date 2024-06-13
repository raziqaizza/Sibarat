package com.example.sibarat.activity.camera

import androidx.lifecycle.ViewModel
import com.example.sibarat.data.Repository
import okhttp3.MultipartBody
import okhttp3.RequestBody

class CameraViewModel (private val repository: Repository): ViewModel() {
    fun uploadImage(image: MultipartBody.Part) = repository.uploadImage(image)

}