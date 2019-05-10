package com.example.fbproj1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class DetailsOfPhoto : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_of_photo)

        val photo: PhotoCardItem = intent.getSerializableExtra("photo") as PhotoCardItem;

//        findViewById<TextView>(R.id.tv0).text = photo.pciUrl
        val btnChangeToAnotherMode = (findViewById(R.id.btnChangeMode) as Button)
        btnChangeToAnotherMode.setOnClickListener(View.OnClickListener {
            changeMode()
        });

        defaultFragment();

    }

    fun changeMode() {
        val fg: FragmentManager = supportFragmentManager;
        val fTransaction: FragmentTransaction = fg.beginTransaction()

        val fragPhotoData: fragPhotoData  = fragPhotoData();
        fTransaction.replace(R.id.framelayouttop, fragPhotoData);
        fTransaction.commit();

        val flBottom : FrameLayout = findViewById(R.id.framelayoutbottom);
        val paramsBottom  = flBottom.layoutParams;
        paramsBottom.height = 0;
        paramsBottom.width = 0;
        flBottom.layoutParams = paramsBottom;

        val flTop : FrameLayout = findViewById(R.id.framelayouttop);
        val paramsTop  = flBottom.layoutParams;
        paramsTop.height = 600;
        paramsTop.width = 266;
        flTop.layoutParams = paramsTop;

//        framelayoutbottom
//        val fragSimilarPhotos: fragSimilarPhotos  = fragSimilarPhotos();
//        val fl2: FrameLayout = FrameLayout(this);
    }

    fun defaultFragment() {
        val fg: FragmentManager = supportFragmentManager;
        val fTransaction: FragmentTransaction = fg.beginTransaction()

        val fragSimilarPhotos: fragSimilarPhotos  = fragSimilarPhotos();
        val fragPhotoData: fragPhotoData  = fragPhotoData();

        fTransaction.add(R.id.framelayouttop, fragSimilarPhotos);
        fTransaction.add(R.id.framelayoutbottom, fragPhotoData);

        fTransaction.commit();
    }


}
