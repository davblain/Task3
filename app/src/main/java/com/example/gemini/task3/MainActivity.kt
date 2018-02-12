package com.example.gemini.task3

import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makePhotoButton.setOnClickListener {
           val makePictureIntent =  Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(makePictureIntent,REQUEST_IMAGE_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val extras = data?.extras
            startActivity(PhotoPreviewActivity.newIntent(this,extras?.get("data") as Bitmap,nameTextEdit.text.toString()))
        }

    }
}
