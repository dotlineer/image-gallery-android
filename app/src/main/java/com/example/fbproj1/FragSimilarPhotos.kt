package com.example.fbproj1

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView



class FragSimilarPhotos(val photo: PhotoCardItem, val photoCollection: ArrayList<PhotoCardItem>) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_frag_similar_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var similarPhotos: ArrayList<PhotoCardItem> = photo.getPhotosWithAMatchingTag(photoCollection)

        val gridview = view!!.findViewById<GridView>(R.id.gv_similar_photos)
        gridview.setAdapter(ImageAdapterGridView(activity!!.applicationContext, similarPhotos));

    }

}


