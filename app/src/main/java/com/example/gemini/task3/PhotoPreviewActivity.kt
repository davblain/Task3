package com.example.gemini.task3

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_photo_preview.*
import java.io.File
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth



class PhotoPreviewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_preview)
        photoImage.setImageBitmap(BitmapFactory.decodeFile(intent.extras[PHOTO_PATH] as String))
        signatureTextView.text = intent.extras[NAME] as String
    }


    companion object {

        private val PHOTO_PATH = "photo";
        private val NAME = "name"
        fun newIntent(context: Context,photo:String, name: String): Intent {
            val intent = Intent(context, PhotoPreviewActivity::class.java)
            intent.putExtra(PHOTO_PATH, photo)
            intent.putExtra(NAME,name)
            return intent
        }


    }
}
