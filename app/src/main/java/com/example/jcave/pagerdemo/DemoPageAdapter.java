package com.example.jcave.pagerdemo;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DemoPageAdapter{

    public static class PageAdapter extends FragmentPagerAdapter {

        private final List fragments;
        private final List fragmentTitles;

        public PageAdapter(FragmentManager fm) {
            super(fm);
            List fragments = (List)(new ArrayList());
            this.fragments = fragments;
            List fragmentTitles = (List)(new ArrayList());
            this.fragmentTitles = fragmentTitles;
        }

        @Override
        public Fragment getItem(int i) {
            return (Fragment)this.fragments.get(i);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return (String)this.fragmentTitles.get(position);
        }

        public final void addFragment(@NotNull Fragment fragment, @NotNull String title) {
            this.fragments.add(fragment);
            this.fragmentTitles.add(title);
        }
    }

}