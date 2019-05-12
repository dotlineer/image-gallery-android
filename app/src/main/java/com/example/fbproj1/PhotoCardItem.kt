package com.example.fbproj1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_card_item)
    }


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
        val picturesThatShareAtLeastOneTag: ArrayList<PhotoCardItem> = ArrayList<PhotoCardItem>()
        var i = 0

        for (photoFromCollection in photoCollectionWithoutReferenePhoto) {
            if (i < MAX_SIMILAR_PHOTOS) {
                val referencePhotoTempTagArray = ArrayList<String>(referencePhoto.pciTags)
                referencePhotoTempTagArray.retainAll(photoFromCollection.pciTags)
                if (!referencePhotoTempTagArray.isEmpty()) {
                    picturesThatShareAtLeastOneTag.add(photoFromCollection)
                }
            }
            else {
                break
            }
            i += 1
        }
        return picturesThatShareAtLeastOneTag
    }


    companion object {
        val MAX_SIMILAR_PHOTOS = 6
    }

}


