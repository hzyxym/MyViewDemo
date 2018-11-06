package com.fzs.hzy.myviewdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.fzs.hzy.myviewdemo.R;
import com.fzs.hzy.myviewdemo.ScrollViewViewPager.UninterceptableViewPager;
import com.fzs.hzy.myviewdemo.ScrollViewViewPager.WrapContentViewPager;
import com.fzs.hzy.myviewdemo.fragmemt.AFragment;
import com.fzs.hzy.myviewdemo.fragmemt.ContentFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerInScrollViewActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private WrapContentViewPager viewPager;
    private String[] titles = {"a","b"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_in_scrollview);
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);
        ArrayList<Fragment> fragments = new ArrayList<>();
        // 装填
        fragments.add(new AFragment());
        fragments.add(new ContentFragment());

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.setFragments(fragments);
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.reMeasureCurrentPage(viewPager.getCurrentItem());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragmentList;

        public void setFragments(ArrayList<Fragment> fragments) {
            mFragmentList = fragments;
        }

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = mFragmentList.get(position);

            return fragment;
        }

        @Override
        public int getCount() {

            return mFragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
