package com.example.car.BuyFragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyBuyFragmentAdapter extends FragmentPagerAdapter {

    private String[] mTitle = {"火花塞","车尾蜘蛛侠","前保险杠下护板"};

    public MyBuyFragmentAdapter(FragmentManager fragmentManager){
        super(fragmentManager);

    }
    @Override
    public Fragment getItem(int i) {
        if (i == 1){
            return  new BuyTwoFragment();
        }else if(i == 2){
            return  new BuyThreeFragment();
        }
        return new BuyOneFragment();
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
