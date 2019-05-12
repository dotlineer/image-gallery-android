package com.example.fbproj1

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import java.lang.StringBuilder

class PhotoCardItem(val pciUrl: String = "", val pciTitle: String = "", val pciDate: String = "", val pciTags: ArrayList<String> = ArrayList<String>(), val pciBitmapDataObj: BitmapDataObject) : java.io.Serializable, AppCompatActivity() {

    override fun toString(): String {
        var strBuf: StringBuffer = StringBuffer()
        strBuf.append(pciUrl + " " + pciTitle + " " + pciDate + " ")

        for (tag in pciTags) {
            strBuf.append(" " + tag)
        }

        return strBuf.toString()
    }

    fun getFormattedTagString(): String {
        val tagString: StringBuilder = StringBuilder()
        for (tag in pciTags) {
            tagString.append(tag + " ")
        }
        return tagString.toString()
    }

//    fun getPhotosWithAMatchingTag(): ArrayList<String> {
//        val arRet: ArrayList<String> = ArrayList(pciTags.filter { tag -> tag.equals(tagToMatch)})
//        return arRet
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_card_item)
    }

//    fun getPhotosWithAMatchingTag(referencePhoto: PhotoCardItem, photoCollection: ArrayList<PhotoCardItem>): ArrayList<PhotoCardItem> {
//        val picturesThatShareAtLeastOneTag: ArrayList<PhotoCardItem> = ArrayList<PhotoCardItem>()
//        for (photoFromCollection in photoCollection) {
//            val referencePhotoTempTagArray = ArrayList<String>(referencePhoto.pciTags)
//            referencePhotoTempTagArray.retainAll(photoFromCollection.pciTags)
//            if (!referencePhotoTempTagArray.isEmpty()) {
//                picturesThatShareAtLeastOneTag.add(photoFromCollection)
//            }
////            val commonTags: ArrayList<PhotoCardItem> = referencePhoto.pciTags.retainAll(photoFromCollection.pciTags)
//        }
//        return picturesThatShareAtLeastOneTag
//    }

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as PhotoCardItem

        if (pciUrl != other.pciUrl) return false
        if (pciTitle != other.pciTitle) return false
        if (pciDate != other.pciDate) return false
        if (pciTags != other.pciTags) return false

        return true
    }


    fun getPhotosWithAMatchingTag(photoCollection: ArrayList<PhotoCardItem>): ArrayList<PhotoCardItem> {
        val referencePhoto = this
        val photoCollectionWithoutReferenePhoto: ArrayList<PhotoCardItem> = ArrayList(photoCollection.filter {curPhoto -> !curPhoto.equals(referencePhoto) })
        //        val arRet: ArrayList<String> = ArrayList(pciTags.filter { tag -> tag.equals(tagToMatch)})


        val picturesThatShareAtLeastOneTag: ArrayList<PhotoCardItem> = ArrayList<PhotoCardItem>()
        for (photoFromCollection in photoCollectionWithoutReferenePhoto) {
            val referencePhotoTempTagArray = ArrayList<String>(referencePhoto.pciTags)
            referencePhotoTempTagArray.retainAll(photoFromCollection.pciTags)
            if (!referencePhotoTempTagArray.isEmpty()) {
                picturesThatShareAtLeastOneTag.add(photoFromCollection)
            }
//            val commonTags: ArrayList<PhotoCardItem> = referencePhoto.pciTags.retainAll(photoFromCollection.pciTags)
        }
        return picturesThatShareAtLeastOneTag
    }

}
