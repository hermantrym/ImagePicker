package com.ctl.imagepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts

class UploadImageActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var btnBrowse: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_image)

        image = findViewById(R.id.imageView3)
        btnBrowse = findViewById(R.id.button)

        val galleryImage = registerForActivityResult(ActivityResultContracts.GetContent(), {
            image.setImageURI(it)
        })

        btnBrowse.setOnClickListener {
            galleryImage.launch("image/*")
        }
    }
}