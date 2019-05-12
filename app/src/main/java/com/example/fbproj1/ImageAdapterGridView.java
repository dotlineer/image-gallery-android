package com.example.fbproj1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapterGridView extends BaseAdapter {
    private Context context;
    private ArrayList<PhotoCardItem> photoCollection;

    public ImageAdapterGridView(Context context, ArrayList<PhotoCardItem> photoCollection) {
        this.context = context;
        this.photoCollection = photoCollection;
    }

    public int getCount() {
        return photoCollection.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageBitmap(photoCollection.get(position).getPciBitmapDataObj().getCurrentImage());
        return imageView;
    }

}