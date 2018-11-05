package com.example.jcave.pagerdemo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)

        viewModel.getData().observe(this, Observer {
            Toast.makeText(this, "Activity: $it", Toast.LENGTH_SHORT).show()
        })

        val tabLayout = tab_nav
        val viewPager = view_pager_video

        //  val pagerAdapter = MyPagerAdapter(supportFragmentManager)
        val pagerAdapter = PageAdapter(supportFragmentManager)

        pagerAdapter.addFragment("First")
        pagerAdapter.addFragment( "Second")
        pagerAdapter.addFragment( "Third")
        pagerAdapter.addFragment( "Fourth")

        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)


    }


}
