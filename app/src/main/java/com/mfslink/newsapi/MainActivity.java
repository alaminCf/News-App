package com.mfslink.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tablay;
    TabItem home, sports, science, technology, entertainment, health;
    Toolbar toolbar;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;

    String apikey = "9e555fb76bbf4aeab5b9dca583da40a6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tablay = findViewById(R.id.tablay);
        home = findViewById(R.id.home);
        sports = findViewById(R.id.sports);
        science = findViewById(R.id.science);
        technology = findViewById(R.id.technology);
        entertainment = findViewById(R.id.entertainment);
        health = findViewById(R.id.health);
        viewPager = findViewById(R.id.viewpager);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

        tablay.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3
                || tab.getPosition()==4 || tab.getPosition()==5){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablay));


    }
}