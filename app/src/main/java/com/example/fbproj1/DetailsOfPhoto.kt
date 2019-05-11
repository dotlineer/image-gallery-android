package com.example.fbproj1

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

enum class PhotoViewMode {
    FULL_PHOTO, DATA_AND_SIMILAR_PHOTOS;
}

class DetailsOfPhoto(var currentMode: PhotoViewMode = PhotoViewMode.FULL_PHOTO, val fFullPhoto: FragFullPhoto = FragFullPhoto(), val fPhotoData: FragPhotoData = FragPhotoData(), val fSimilarPhotos: FragSimilarPhotos = FragSimilarPhotos() ) : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_of_photo)

        val photo: PhotoCardItem = intent.getSerializableExtra("photo") as PhotoCardItem;

        val btnChangeToAnotherMode = (findViewById(R.id.btnChangeMode) as Button)
        btnChangeToAnotherMode.setOnClickListener(View.OnClickListener {
//            fFullPhoto.view!!.setBackgroundColor(Color.CYAN);
//            fPhotoData.view!!.setBackgroundColor(Color.RED);
//            fSimilarPhotos.view!!.setBackgroundColor(Color.YELLOW);

            when (currentMode) {
                PhotoViewMode.FULL_PHOTO -> setPhotoViewMode(PhotoViewMode.DATA_AND_SIMILAR_PHOTOS)
                PhotoViewMode.DATA_AND_SIMILAR_PHOTOS -> setPhotoViewMode(PhotoViewMode.FULL_PHOTO)
            }
        });

//        fFullPhoto.view!!.setBackgroundColor(Color.CYAN);
//        fPhotoData.view!!.setBackgroundColor(Color.RED);
//        fSimilarPhotos.view!!.setBackgroundColor(Color.YELLOW);

        setPhotoViewMode(PhotoViewMode.DATA_AND_SIMILAR_PHOTOS);

    }

    fun setPhotoViewMode(modeToChangeTo: PhotoViewMode) {
//        val height: Integer = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, <HEIGHT>, getResources().getDisplayMetrics());

        when (modeToChangeTo) {
            PhotoViewMode.FULL_PHOTO -> {
                val flTop: FrameLayout = findViewById(R.id.framelayouttop);
                val paramsTop = flTop.layoutParams;
                paramsTop.height = 600;
                paramsTop.width = 370;
                flTop.layoutParams = paramsTop;

                val flBottom: FrameLayout = findViewById(R.id.framelayoutbottom);
                val paramsBottom = flBottom.layoutParams;
                paramsBottom.height = 0;
                paramsBottom.width = 0;
                flBottom.layoutParams = paramsBottom;

                val fManager: FragmentManager = supportFragmentManager;
                val fTransaction: FragmentTransaction = fManager.beginTransaction()
                fTransaction.replace(R.id.framelayouttop, fFullPhoto);
//                fTransaction.hide(flBottom);
                fTransaction.commit();

                flBottom.visibility = View.GONE;

//                val ft = fragmentManager.beginTransaction()


                currentMode = PhotoViewMode.FULL_PHOTO;
            }

            PhotoViewMode.DATA_AND_SIMILAR_PHOTOS -> {
                val flTop: FrameLayout = findViewById(R.id.framelayouttop);
                val paramsTop = flTop.layoutParams;
                paramsTop.height = 305;
                paramsTop.width = 370;
                flTop.layoutParams = paramsTop;

                val flBottom: FrameLayout = findViewById(R.id.framelayoutbottom);
                val paramsBottom = flBottom.layoutParams;
                paramsBottom.height = 305;
                paramsBottom.width = 370;
                flBottom.layoutParams = paramsBottom;

                val fManager: FragmentManager = supportFragmentManager;
                val fTransaction: FragmentTransaction = fManager.beginTransaction()
                fTransaction.replace(R.id.framelayouttop, fPhotoData);
                fTransaction.replace(R.id.framelayoutbottom, fSimilarPhotos);
                fTransaction.commit();

                currentMode = PhotoViewMode.DATA_AND_SIMILAR_PHOTOS;
            }
        }



//        if (currentMode == PhotoViewMode.FULL_PHOTO) {
//
//            currentMode == PhotoViewMode.DATA_AND_SIMILAR_PHOTOS
//        }
//
//        else if (currentMode == PhotoViewMode.DATA_AND_SIMILAR_PHOTOS) {
//
//            currentMode == PhotoViewMode.FULL_PHOTO
//        }

//        val fg: FragmentManager = supportFragmentManager;
//        val fTransaction: FragmentTransaction = fg.beginTransaction()
//
//        val fragPhotoData: fragPhotoData  = fragPhotoData();
//        fTransaction.replace(R.id.framelayouttop, fragPhotoData);
//        fTransaction.commit();
//
//        val flBottom : FrameLayout = findViewById(R.id.framelayoutbottom);
//        val paramsBottom  = flBottom.layoutParams;
//        paramsBottom.height = 0;
//        paramsBottom.width = 0;
//        flBottom.layoutParams = paramsBottom;
//
//        val flTop : FrameLayout = findViewById(R.id.framelayouttop);
//        val paramsTop  = flBottom.layoutParams;
//        paramsTop.height = 600;
//        paramsTop.width = 266;
//        flTop.layoutParams = paramsTop;

//        framelayoutbottom
//        val fragSimilarPhotos: fragSimilarPhotos  = fragSimilarPhotos();
//        val fl2: FrameLayout = FrameLayout(this);
    }

    fun defaultFragment() {
//        val fg: FragmentManager = supportFragmentManager;
//        val fTransaction: FragmentTransaction = fg.beginTransaction()
//
//        val fragSimilarPhotos: fragSimilarPhotos  = fragSimilarPhotos();
//        val fragPhotoData: fragPhotoData  = fragPhotoData();
//
//        fTransaction.add(R.id.framelayouttop, fragSimilarPhotos);
//        fTransaction.add(R.id.framelayoutbottom, fragPhotoData);
//
//        fTransaction.commit();
    }


}
