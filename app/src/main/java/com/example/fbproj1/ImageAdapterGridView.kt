package com.example.fbproj1

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView

class ImageAdapter(private val context: Context) : BaseAdapter() {

    //---returns the number of images---
    override fun getCount(): Int {
        return imageIDs.length
    }

    //---returns the ID of an item---
    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //---returns an ImageView view---
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(context)
            imageView.layoutParams = GridView.LayoutParams(185, 185)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(5, 5, 5, 5)
        } else {
            imageView = convertView as ImageView?
        }
        imageView.setImageResource(imageIDs[position])
        return imageView
    }
}