package com.example.car;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private Context mcontext;
    private List<Fragment> fragmentList;

    public  MyFragmentAdapter(FragmentManager fragmentManager, Context context, List<Fragment> fragments){
        super(fragmentManager);
        this.mcontext = context;
        this.fragmentList = fragments;

    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }
}
