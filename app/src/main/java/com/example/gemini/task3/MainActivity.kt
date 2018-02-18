package com.example.gemini.task3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v4.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private val REQUEST_IMAGE_CAPTURE = 1
    private var createdFile:File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makePhotoButton.setOnClickListener { makePhoto() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            startActivity(PhotoPreviewActivity.newIntent(this, createdFile!!.absolutePath, nameTextEdit.text.toString()))
        }

    }

    private fun  makePhoto() {
        createdFile = createPhotoFile()
        if (createdFile!=null) {
            val photoUri = FileProvider.getUriForFile(this, "com.gemini.fileprovider", createdFile)
            val makePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            makePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            startActivityForResult(makePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    private fun createPhotoFile():File?{
        try {
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val imageFileName = "JPEG_" + timeStamp + "_"
            val mediaStorageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            return File.createTempFile(imageFileName,
                    ".jpg",
                    mediaStorageDir)
        } catch (e: IOException) {
            showErr(getString(R.string.could_not_create_file))
            return null
        }
    }

    private fun showErr(message:String) {
        Snackbar.make(root,message,Snackbar.LENGTH_LONG).show()
    }
}
