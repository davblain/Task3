package com.example.gemini.task3

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_photo_preview.*

class PhotoPreviewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_preview)
        photoImage.setImageBitmap(intent.extras[PHOTO] as Bitmap)
        signatureTextView.text = intent.extras[NAME] as String
    }

    companion object {

        private val PHOTO = "photo";
        private val NAME = "name"
        fun newIntent(context: Context,photo:Bitmap, name: String): Intent {
            val intent = Intent(context, PhotoPreviewActivity::class.java)
            intent.putExtra(PHOTO, photo)
            intent.putExtra(NAME,name)
            return intent
        }


    }
}
