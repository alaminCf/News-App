package com.mfslink.newsapi;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
            return new Home_fragment();

            case 1:
                return new Sports_fragment();

            case 2:
                return new Science_fragment();

            case 3:
                return new Technology_fragment();

            case 4:
                return new Entertainment_fragment();

            case 5:
                return new Health_fragment();


            default:
                return null;

        }



    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
