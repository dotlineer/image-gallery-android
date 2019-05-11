package com.example.fbproj1

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.squareup.picasso.Picasso
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.DatePicker
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputEditText
import java.text.DateFormat
import java.util.*


class AddPhotoForm() : AppCompatActivity(), DatePickerDialog.OnDateSetListener  {

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val c: Calendar = Calendar.getInstance()
        c.set(Calendar.YEAR, year)
        c.set(Calendar.MONTH, month)
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        val sDate: String = DateFormat.getDateInstance().format(c.time)

        findViewById<TextView>(R.id.tiet_date).text = sDate
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_photo_form)

        val photos: ArrayList<PhotoCardItem> = intent.getSerializableExtra("photos") as ArrayList<PhotoCardItem>

        findViewById<TextView>(R.id.tiet_date).text = DateFormat.getDateInstance().format(java.util.Calendar.getInstance().time)


        findViewById<TextInputLayout>(R.id.til_date).setOnClickListener {
            val datePicker: DialogFragment = DatePickerFragment()
            datePicker.show(supportFragmentManager, "date picker")
        }

        findViewById<TextInputEditText>(R.id.tiet_date).onFocusChangeListener = View.OnFocusChangeListener { view, b ->
            if (b) {
                val datePicker: DialogFragment = DatePickerFragment()
                datePicker.show(supportFragmentManager, "date picker")
            }
        }


        val btnAddPhoto = (findViewById(R.id.btn_add_photo) as Button)
        btnAddPhoto.setOnClickListener(View.OnClickListener {

            val url: String = (findViewById<TextInputLayout>(R.id.til_url)).editText!!.text.toString()

            Picasso.get()
                .load(url)
                .resize(500, 500)
                .centerInside()
                .into(object: com.squareup.picasso.Target {
                    override fun onBitmapFailed(e: java.lang.Exception?, errorDrawable: Drawable?) {
                    }

                    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                    }

                    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                        val title: String = findViewById<TextInputLayout>(R.id.til_title).editText!!.text.toString()
                        val date: String = findViewById<TextInputLayout>(R.id.til_date).editText!!.text.toString()

                        val tags: ArrayList<String> = ArrayList<String>()

                        val pciBitmapToAdd: Bitmap = bitmap!!
                        val pciBitmapDataObjToAdd: BitmapDataObject = BitmapDataObject(pciBitmapToAdd)

                        val photo: PhotoCardItem = PhotoCardItem(url, title, date, tags, pciBitmapDataObjToAdd)
                        photos.add(photo)

                        val intentReturn: Intent = Intent()
                        intentReturn.putExtra("photos", photos)
                        setResult(Activity.RESULT_OK, intentReturn)
                        finish()

//                        val fbImg = FirebaseVisionImage.fromBitmap(btmap)
//                    val labeler = FirebaseVision.getInstance().getOnDeviceImageLabeler()
//
//                    labeler.processImage(fbImg)
//                    .addOnSuccessListener { labels ->
//
//                        for (label in labels) {
//                            val text = label.text
//                            val entityId = label.entityId
//                            val confidence = label.confidence
//
//                            if (confidence >= 0.5) {
//                                tags.add(text)
//                            }
//
//                        }
//
//                        val photo: PhotoCardItem = PhotoCardItem(url, title, date, tags)
//                        photos.add(photo)
//
//                        val intentReturn: Intent = Intent()
//                        intentReturn.putExtra("photos", photos)
//                        setResult(Activity.RESULT_OK, intentReturn)
//                        finish()
//                    }
//                    .addOnFailureListener { e ->
//                        e.printStackTrace()
//
//                        val intentReturn: Intent = Intent()
//                        setResult(Activity.RESULT_CANCELED, intentReturn)
//                        finish()
//                    }
                }
                })




        })

    }


}

