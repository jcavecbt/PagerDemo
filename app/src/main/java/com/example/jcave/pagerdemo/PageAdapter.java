package com.example.jcave.pagerdemo;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class PageAdapter extends FragmentPagerAdapter {

    private final List fragmentTitles;

    public PageAdapter(FragmentManager fm) {
        super(fm);
        this.fragmentTitles = new ArrayList();
    }

    @Override
    public Fragment getItem(int i) {
        return new FirstFragment();
    }

    @Override
    public int getCount() {
        return this.fragmentTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (String) this.fragmentTitles.get(position);
    }

    public final void addFragment( @NotNull String title) {
        this.fragmentTitles.add(title);
    }
}
