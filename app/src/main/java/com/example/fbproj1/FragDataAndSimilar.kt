package com.example.fbproj1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction



class FragDataAndSimilar(val photo: PhotoCardItem, val photoCollection: ArrayList<PhotoCardItem>) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_frag_data_and_similar, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentManager: FragmentManager? = fragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction();

        val fPhotoData: Fragment = FragPhotoData(photo)
        val fSimilarPhotos: Fragment = FragSimilarPhotos(photo, photoCollection)

        fragmentTransaction.replace(R.id.fl_top_data, fPhotoData)
        fragmentTransaction.replace(R.id.fl_bottom_similar, fSimilarPhotos)
        fragmentTransaction.commit()
    }

}
