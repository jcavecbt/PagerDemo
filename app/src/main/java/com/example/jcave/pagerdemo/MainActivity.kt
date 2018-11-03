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

        val pagerAdapter = MyPagerAdapter(supportFragmentManager)
//        val pagerAdapter = DemoPageAdapter.PageAdapter(supportFragmentManager)

        pagerAdapter.addFragment(FirstFragment.newInstance(), "First")
        pagerAdapter.addFragment(SecondFragment.newInstance(), "Second")
        pagerAdapter.addFragment(FirstFragment.newInstance(), "Third")
        pagerAdapter.addFragment(SecondFragment.newInstance(), "Fourth")

        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)


    }

    private inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val fragments = mutableListOf<Fragment>()
        private val fragmentTitles = mutableListOf<String>()

        override fun getItem(p0: Int): Fragment {
            return fragments[p0]
        }

        override fun getCount(): Int {
           return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return fragmentTitles[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            fragmentTitles.add(title)
        }
    }
}
