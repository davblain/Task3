package com.example.gemini.task3

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_photo_preview.*
import kotlinx.android.synthetic.main.activity_photo_preview.view.*

class PhotoPreviewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_preview)
        val  phoneBitMap = intent.extras[PHOTO] as Bitmap
        photoImage.setImageBitmap(phoneBitMap)
        Toast.makeText(this,phoneBitMap.width.toString(),Toast.LENGTH_SHORT).show()
        Toast.makeText(this,phoneBitMap.height.toString(),Toast.LENGTH_SHORT).show()
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
