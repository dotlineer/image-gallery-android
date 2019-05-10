package com.example.fbproj1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.ArrayList

class DetailsOfPhoto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_of_photo)

        val photo: PhotoCardItem = intent.getSerializableExtra("photo") as PhotoCardItem;

        findViewById<TextView>(R.id.tv0).text = photo.pciUrl


    }
}
