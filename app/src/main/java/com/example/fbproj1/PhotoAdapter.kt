package com.example.fbproj1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PhotoAdapter(val context: Context, private val mDataList: ArrayList<PhotoCardItem>) : java.io.Serializable, RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    val MAX_TAGS = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_photo_card_item, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val url: String = mDataList[position].pciUrl

        Picasso.get().load(url).into(holder.ivImg)
        holder.tvTitle.text = mDataList[position].pciTitle
        holder.tvTags.setText("")

        var i = 0
        for (tag in mDataList[position].pciTags) {
            if (i<MAX_TAGS-1) {
                holder.tvTags.append(tag + "; ")
            }
            i += 1
        }

        holder.tvDate.text = mDataList[position].pciDate
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var ivImg: ImageView = itemView.findViewById(R.id.pci_img) as ImageView
        internal var tvTitle: TextView = itemView.findViewById(R.id.pci_title) as TextView
        internal var tvTags: TextView = itemView.findViewById(R.id.pci_tags) as TextView
        internal var tvDate: TextView = itemView.findViewById(R.id.pci_date) as TextView
    }

}

