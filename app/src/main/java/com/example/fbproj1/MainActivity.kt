package com.example.fbproj1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.*


class MainActivity : AppCompatActivity() {

    private val ADD_NEW_PHOTO = 990
    val photos: ArrayList<PhotoCardItem> = ArrayList(10)
    lateinit var adapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso.get().setLoggingEnabled(true)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayShowTitleEnabled(true);
        supportActionBar!!.setTitle(R.string.main_activity_title)

        photos.ensureCapacity(10)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_photos) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter = PhotoAdapter(this, photos)
        recyclerView.adapter = adapter

        val ith = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                photos.removeAt(viewHolder.adapterPosition)
                adapter.notifyItemRemoved(viewHolder.adapterPosition)
            }
        })
        ith.attachToRecyclerView(recyclerView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_add_photo -> {
                val intent = Intent(this@MainActivity, AddPhotoForm::class.java)
                intent.putExtra("photos", photos)
                startActivityForResult(intent, ADD_NEW_PHOTO)
            }
            else -> { }
        }

        return super.onOptionsItemSelected(item)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK)
            when (requestCode) {
                ADD_NEW_PHOTO -> {
                    val ar: ArrayList<PhotoCardItem> =  data!!.getSerializableExtra("photos") as ArrayList<PhotoCardItem>

                    photos.clear()
                    for (p in ar) {
                        photos.add(p)
                    }

                    adapter.notifyDataSetChanged()
                }
            }
    }


}
