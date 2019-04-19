package com.example.fbproj1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class PhotoCardItem(val pciUrl: String, val pciTitle: String, val pciDate: String, val pciTags: ArrayList<String>) : java.io.Serializable, AppCompatActivity() {

    override fun toString(): String {
        var strBuf: StringBuffer = StringBuffer()
        strBuf.append(pciUrl + " " + pciTitle + " " + pciDate + " ")

        for (tag in pciTags) {
            strBuf.append(" " + tag)
        }

        return strBuf.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_card_item)
    }


}
