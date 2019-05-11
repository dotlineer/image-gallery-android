package com.example.fbproj1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
//import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import android.view.Menu
import android.view.MenuItem


class Details : AppCompatActivity() {

    private lateinit var mSectionsPagerAdapter: SectionsPagerAdapter;
    private lateinit var mViewPager: ViewPager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val toolbar = findViewById(R.id.mytoolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);

        mSectionsPagerAdapter = SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.viewPager) as ViewPager;
        mViewPager.setAdapter(mSectionsPagerAdapter);

        val tabLayout = findViewById<View>(R.id.tabLayout) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)
    }


//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id = item.getItemId()
//
//        return if (id == R.id.action_settings) {
//            true
//        } else super.onOptionsItemSelected(item)
//    }


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = FragFullPhoto()
                1 -> fragment = Frag2()
            }
            return fragment
        }

        override fun getCount(): Int {
            return 2;
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return getString(R.string.frag_full_photo_desc);
                1 -> return getString(R.string.frag_photo_details_desc);
            }
            return null
        }
    }


}